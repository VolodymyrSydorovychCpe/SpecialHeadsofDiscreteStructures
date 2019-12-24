package vs.sydorovych;

import java.util.*;

public class GraphWithPrimAlgorithm extends Graph<Integer> {

    public void reorganizeGraphToTree() {
        graphHigh.isPassed = true;
        List<Entity> checkedEntities = new ArrayList<>();
        checkedEntities.add(graphHigh);
        reorganizeGraphToTree(checkedEntities);
    }

    private void reorganizeGraphToTree(List<Entity> checkedEntities) {
        Entity entitiesToCheck =
                checkedEntities.stream().flatMap(entity -> Arrays.stream(new Entity[]{entity.left, entity.right}))
                        .filter(Objects::nonNull)
                        .filter(entity -> !entity.isPassed)
                        .min(Comparator.comparing((Entity entity) -> (int) entity.getValue()))
                        .orElse(null);

        if (entitiesToCheck == null) {
            removeAllRedundantRibs();
            return;
        }

        entitiesToCheck.isPassed = true;
        checkedEntities.add(entitiesToCheck);
        reorganizeGraphToTree(checkedEntities);
    }

    private void removeAllRedundantRibs() {
        List<Entity> entitiesToCheck = new ArrayList<>();
        entitiesToCheck.add(graphHigh);
        removeAllRedundantRibs(entitiesToCheck);
    }

    private void removeAllRedundantRibs(List<Entity> entitiesToCheck) {
        if (entitiesToCheck.size() == 0) {
            return;
        }

        List<Entity> newEntitiesToCheck = new ArrayList<>();

        entitiesToCheck.forEach(entity -> {
            if (entity.left != null && !entity.left.isPassed) {
                entity.left = null;
            } else if (entity.left != null) {
                newEntitiesToCheck.add(entity.left);
            }
            if (entity.right != null && !entity.right.isPassed) {
                entity.right = null;
            } else if (entity.right != null) {
                newEntitiesToCheck.add(entity.right);
            }
        });

        removeAllRedundantRibs(newEntitiesToCheck);
    }
}
