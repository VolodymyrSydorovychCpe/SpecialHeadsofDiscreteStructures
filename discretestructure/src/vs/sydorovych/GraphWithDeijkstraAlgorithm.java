package vs.sydorovych;

import java.util.ArrayList;
import java.util.List;

public class GraphWithDeijkstraAlgorithm extends Graph<Integer> {

    public void recountShortestPaths() {
        graphHigh.pathLength = 0;
        recountShortestPaths(graphHigh);
    }

    private void recountShortestPaths(Entity entity) {
        if (entity.isPassed) {
            return;
        }
        int pathLengthToCurrentEntity = entity.pathLength;
        getAllChildren(entity).forEach(childEntity ->
                childEntity.pathLength = childEntity.pathLength > pathLengthToCurrentEntity + (int)childEntity.getValue()
                        ? pathLengthToCurrentEntity + (int)childEntity.getValue()
                        : childEntity.pathLength
        );
        getAllChildren(entity).forEach(this::recountShortestPaths);
        entity.isPassed = true;
    }

    private List<Entity> getAllChildren(Entity entity) {
        List<Entity> result = new ArrayList<>();
        if (entity.left != null) {
            result.add(entity.left);
        }
        if (entity.right != null) {
            result.add(entity.right);
        }
        return result;
    }

}
