package vs.sydorovych;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Graph<T extends Comparable<T>> {

    protected Entity<T> graphHigh;

    private int size;

    public Graph() {
    }

    public int getSize() {
        return size;
    }

    public int findHigh() {
        return findHigh(graphHigh);
    }

    public Entity<T> add(T value) {
        Entity<T> result;
        if (graphHigh == null) {
            result = new Entity<>(value, null);
            graphHigh = result;
            size++;
        } else {
            result = addToGraph(value, graphHigh);
        }
        return result;
    }

    public boolean remove(T value) {
        Entity<T> searchedEntity = findEntity(value, graphHigh);
        return searchedEntity != null && remove(searchedEntity);
    }

    public Entity<T> findEntity(T value) {
        return findEntity(value, graphHigh);
    }

    public List<T> goThroughGraphDeapthFirst() {
        List<T> result = new ArrayList<>();
        return goInDepth(graphHigh, result);
    }

    public List<T> goThroughGraphWidthFirst() {
        return getEntitiesWithGraphWidthFirstApproach().stream()
                .map(entity -> entity.value)
                .collect(Collectors.toList());
    }

    public List<Pair<Entity, Entity>> getRibs() {
        return getRibs(graphHigh);
    }

    protected List<Entity<T>> getEntitiesWithGraphWidthFirstApproach() {
        List<Entity<T>> result = new ArrayList<>();
        result.add(graphHigh);

        result.addAll(getEntities(result));
        return result;
    }

    private int findHigh(Entity<T> currentNode) {
        if (currentNode == null) {
            return 0;
        }
        int leftHigh = findHigh(currentNode.left) + 1;
        int rightHigh = findHigh(currentNode.right) + 1;

        return leftHigh > rightHigh ? leftHigh : rightHigh;
    }

    private List<T> goInDepth(Entity<T> currentNode, List<T> result) {
        if (currentNode.left != null) {
            goInDepth(currentNode.left, result);
        }
        result.add(currentNode.value);
        if (currentNode.right != null) {
            goInDepth(currentNode.right, result);
        }
        return result;
    }

    private List<Pair<Entity, Entity>> getRibs(Entity currentEntity) {
        List<Pair<Entity, Entity>> result = new ArrayList<>();
        if (currentEntity.left != null) {
            result.add(new Pair<>(currentEntity, currentEntity.left));
            currentEntity.left.pathLength = Integer.MAX_VALUE;
            result.addAll(getRibs(currentEntity.left));
        }
        if (currentEntity.right != null) {
            result.add(new Pair<>(currentEntity, currentEntity.right));
            currentEntity.right.pathLength = Integer.MAX_VALUE;
            result.addAll(getRibs(currentEntity.right));
        }
        return result;
    }

    private List<Entity<T>> getEntities(List<Entity<T>> previousEntityLine) {
        if (previousEntityLine.size() == 0) {
            return Collections.emptyList();
        }
        List<Entity<T>> result = new ArrayList<>();

        for (Entity<T> entity : previousEntityLine) {
            if (entity.left != null) {
                result.add(entity.left);
            }
            if (entity.right != null) {
                result.add(entity.right);
            }
        }
        result.addAll(getEntities(result));
        return result;
    }

    private boolean remove(Entity<T> entityToRemove) {
        Entity<T> parent = entityToRemove.parent; // todo if entityToRemove is graphHigh

        if (entityToRemove.right == null && entityToRemove.left == null) {
            remove(parent, entityToRemove);
        } else if (entityToRemove.right != null && entityToRemove.left != null) {

            if (parent.value.compareTo(entityToRemove.value) < 0) {  // right side
                parent.right = entityToRemove.right;
                entityToRemove.right.parent = parent;
                Entity<T> lowest = findLowest(entityToRemove.right);
                lowest.left = entityToRemove.left;
                entityToRemove.left.parent = lowest;
            } else if (parent.value.compareTo(entityToRemove.value) > 0) {   // left side
                parent.left = entityToRemove.left;
                entityToRemove.left.parent = parent;
                Entity<T> highest = findHighest(entityToRemove.left);
                highest.right = entityToRemove.right;
                entityToRemove.right.parent = highest;
            }
        } else {
            if (parent.value.compareTo(entityToRemove.value) < 0) {  // right side
                if (entityToRemove.left == null) {
                    parent.right = entityToRemove.right;
                    entityToRemove.right.parent = parent;
                } else {
                    parent.right = entityToRemove.left;
                    entityToRemove.left.parent = parent;
                }
            } else if (parent.value.compareTo(entityToRemove.value) > 0) {   // left side
                if (entityToRemove.left == null) {
                    parent.left = entityToRemove.right;
                    entityToRemove.right.parent = parent;
                } else {
                    parent.left = entityToRemove.left;
                    entityToRemove.left.parent = parent;
                }
            }
        }
        size--;
        return true;
    }

    private Entity<T> findLowest(Entity<T> entity) {
        return entity.left == null ? entity : findLowest(entity.left);
    }

    private Entity<T> findHighest(Entity<T> entity) {
        return entity.right == null ? entity : findHighest(entity.right);
    }

    private void remove(Entity<T> parent, Entity<T> searchedEntity) {
        if (parent.left.value.equals(searchedEntity.value)) {
            parent.left = null;
        } else if (parent.right.value.equals(searchedEntity.value)) {
            parent.right = null;
        }
    }

    private Entity<T> findEntity(T value, Entity<T> currentEntity) {
        if (currentEntity == null) {
            return null;
        }
        if (currentEntity.value.equals(value)) {
            return currentEntity;
        }
        if (currentEntity.value.compareTo(value) < 0) {
            return findEntity(value, currentEntity.right);
        }
        return findEntity(value, currentEntity.left);
    }

    private Entity<T> addToGraph(T value, Entity<T> currentEntity) {
        Entity<T> resultEntity = null;

        if (currentEntity.value.compareTo(value) < 0) {         // should be added to the right side
            if (currentEntity.right == null) {
                currentEntity.right = new Entity<>(value, currentEntity);
                resultEntity = currentEntity.right;
                size++;
            } else {
                resultEntity = addToGraph(value, currentEntity.right);
            }

        } else if (currentEntity.value.compareTo(value) > 0) {  //  should be added to the left side
            if (currentEntity.left == null) {
                currentEntity.left = new Entity<>(value, currentEntity);
                resultEntity = currentEntity.left;
                size++;
            } else {
                resultEntity = addToGraph(value, currentEntity.left);
            }
        } else {
            resultEntity = currentEntity;
        }

        return resultEntity;
    }

    public static class Entity<V extends Comparable<V>> {

        protected Entity<V> parent;

        protected Entity<V> left;

        protected Entity<V> right;

        protected int pathLength = Integer.MAX_VALUE;

        protected boolean isPassed;

        private V value;

        public Entity(V value, Entity<V> parent) {
            this.value = value;
            this.parent = parent;
        }


        public V getValue() {
            return value;
        }

        public int getPathLength() {
            return pathLength;
        }

    }
}
