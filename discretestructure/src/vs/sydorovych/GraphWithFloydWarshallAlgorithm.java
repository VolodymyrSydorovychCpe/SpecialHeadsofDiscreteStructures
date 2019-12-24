package vs.sydorovych;

import java.util.List;

public class GraphWithFloydWarshallAlgorithm extends Graph<Integer> {

    public void recountShortestPathsWithFloydWarshallAlgorithm() {

        List<Entity<Integer>> allHighs = getEntitiesWithGraphWidthFirstApproach();

        Integer[][] distanceMatrix = new Integer[allHighs.size()][allHighs.size()];
        Integer[][] pathMatrix = new Integer[allHighs.size()][allHighs.size()];

        matrixFirstInitialization(allHighs, distanceMatrix, pathMatrix);

        for (int k = 0; k < allHighs.size(); k++) {
            for (int i = 0; i < allHighs.size(); i++) {
                for (int j = 0; j < allHighs.size(); j++) {
                    if (distanceMatrix[i][k] != Integer.MAX_VALUE && distanceMatrix[k][j] != Integer.MAX_VALUE
                            && distanceMatrix[i][j] > distanceMatrix[i][k] + distanceMatrix[k][j]) {
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        pathMatrix[i][j] = pathMatrix[k][j];
                    }
                }

            }
        }

        updateAllEntitiesWithPath(distanceMatrix, allHighs);
    }

    private void updateAllEntitiesWithPath(Integer[][] pathMatrix, List<Entity<Integer>> allHighs) {
        for (int i = 0; i < allHighs.size(); i++) {
            Entity currentEntity = allHighs.get(i);
            currentEntity.pathLength = pathMatrix[0][i];
        }
    }

    private void matrixFirstInitialization(List<Entity<Integer>> allHighs, Integer[][] distanceMatrix, Integer[][] pathMatrix) {
        for (int i = 0; i < allHighs.size(); i++) {
            for (int j = 0; j < allHighs.size(); j++) {
                Entity rowHigh = allHighs.get(i);
                Entity columnHigh = allHighs.get(j);

                if (rowHigh == columnHigh) {
                    distanceMatrix[i][j] = 0;
                    pathMatrix[i][j] = null;
                } else if (rowHigh == columnHigh.parent) {
                    distanceMatrix[i][j] = (int) columnHigh.getValue();
                    pathMatrix[i][j] = i;
                } else {
                    distanceMatrix[i][j] = Integer.MAX_VALUE;
                    pathMatrix[i][j] = null;
                }
            }
        }
    }
}
