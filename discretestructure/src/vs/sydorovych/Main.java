package vs.sydorovych;

public class Main {

    public static void main(String[] args) {

        /*Lab1*/
        System.out.println("--- Lab 1 ---");

        Graph<Integer> integerGraph = new Graph<>();
        integerGraph.add(9);
        integerGraph.add(8);
        integerGraph.add(24);
        integerGraph.add(50);
        integerGraph.add(33);
        integerGraph.add(12);
        integerGraph.add(10);
        integerGraph.add(11);
        integerGraph.add(1);

        integerGraph.remove(8);
        integerGraph.remove(24);

        System.out.println("Graph high: " + integerGraph.findHigh());
        System.out.println("Graph size: " + integerGraph.getSize());

        Graph.Entity<Integer> searchedEntity = integerGraph.findEntity(33);
        System.out.println("Searched value: " + searchedEntity.getValue());
        Graph.Entity<Integer> searchedEntity2 = integerGraph.findEntity(1);
        System.out.println("Searched value: " + searchedEntity2.getValue());
        Graph.Entity<Integer> searchedEntity3 = integerGraph.findEntity(12);
        System.out.println("Searched value: " + searchedEntity3.getValue());

        /*Lab2*/
        System.out.println("--- Lab 2 ---");

        System.out.println(integerGraph.goThroughGraphDeapthFirst());
        System.out.println(integerGraph.goThroughGraphWidthFirst());

        /*lab3*/
        System.out.println("--- Lab 3 ---");

        /*Deijkstra Algoritm*/
        System.out.println("--- Deijkstra algorithm ----");

        GraphWithDeijkstraAlgorithm graphWithDeijkstraAlgorithm = new GraphWithDeijkstraAlgorithm();
        graphWithDeijkstraAlgorithm.add(9);
        graphWithDeijkstraAlgorithm.add(8);
        graphWithDeijkstraAlgorithm.add(24);
        graphWithDeijkstraAlgorithm.add(50);
        graphWithDeijkstraAlgorithm.add(33);
        graphWithDeijkstraAlgorithm.add(12);
        graphWithDeijkstraAlgorithm.add(10);
        graphWithDeijkstraAlgorithm.add(11);
        graphWithDeijkstraAlgorithm.add(1);
        graphWithDeijkstraAlgorithm.remove(8);
        graphWithDeijkstraAlgorithm.remove(24);

        graphWithDeijkstraAlgorithm.recountShortestPaths();

        GraphWithDeijkstraAlgorithm.Entity searchedEntityDeijkstraAlgorithm = graphWithDeijkstraAlgorithm.findEntity(33);
        System.out.println("Searched value: " + searchedEntityDeijkstraAlgorithm.getValue() + ", path length: " + searchedEntityDeijkstraAlgorithm.getPathLength());
        GraphWithDeijkstraAlgorithm.Entity searchedEntityDeijkstraAlgorithm2 = graphWithDeijkstraAlgorithm.findEntity(1);
        System.out.println("Searched value: " + searchedEntityDeijkstraAlgorithm2.getValue() + ", path length: " + searchedEntityDeijkstraAlgorithm2.getPathLength());
        GraphWithDeijkstraAlgorithm.Entity searchedEntityDeijkstraAlgorithm3 = graphWithDeijkstraAlgorithm.findEntity(12);
        System.out.println("Searched value: " + searchedEntityDeijkstraAlgorithm3.getValue() + ", path length: " + searchedEntityDeijkstraAlgorithm3.getPathLength());
        GraphWithDeijkstraAlgorithm.Entity searchedEntityDeijkstraAlgorithm4 = graphWithDeijkstraAlgorithm.findEntity(50);
        System.out.println("Searched value: " + searchedEntityDeijkstraAlgorithm4.getValue() + ", path length: " + searchedEntityDeijkstraAlgorithm4.getPathLength());

        /*Bellman–Ford algorithm*/
        System.out.println("--- Bellman–Ford algorithm ---");

        GraphWithBellmanFordAlgorithm graphWithBellmanFordAlgorithm = new GraphWithBellmanFordAlgorithm();
        graphWithBellmanFordAlgorithm.add(9);
        graphWithBellmanFordAlgorithm.add(8);
        graphWithBellmanFordAlgorithm.add(24);
        graphWithBellmanFordAlgorithm.add(50);
        graphWithBellmanFordAlgorithm.add(33);
        graphWithBellmanFordAlgorithm.add(12);
        graphWithBellmanFordAlgorithm.add(10);
        graphWithBellmanFordAlgorithm.add(11);
        graphWithBellmanFordAlgorithm.add(1);
        graphWithBellmanFordAlgorithm.remove(8);
        graphWithBellmanFordAlgorithm.remove(24);

        graphWithBellmanFordAlgorithm.recountShortestPathsWithBellmanFordAlgorithm();

        GraphWithBellmanFordAlgorithm.Entity searchedEntityBellmanFordAlgorithm = graphWithBellmanFordAlgorithm.findEntity(33);
        System.out.println("Searched value: " + searchedEntityBellmanFordAlgorithm.getValue() + ", path length: " + searchedEntityBellmanFordAlgorithm.getPathLength());
        GraphWithBellmanFordAlgorithm.Entity searchedEntityBellmanFordAlgorithm2 = graphWithBellmanFordAlgorithm.findEntity(1);
        System.out.println("Searched value: " + searchedEntityBellmanFordAlgorithm2.getValue() + ", path length: " + searchedEntityBellmanFordAlgorithm2.getPathLength());
        GraphWithBellmanFordAlgorithm.Entity searchedEntityBellmanFordAlgorithm3 = graphWithBellmanFordAlgorithm.findEntity(12);
        System.out.println("Searched value: " + searchedEntityBellmanFordAlgorithm3.getValue() + ", path length: " + searchedEntityBellmanFordAlgorithm3.getPathLength());
        GraphWithBellmanFordAlgorithm.Entity searchedEntityBellmanFordAlgorithm4 = graphWithBellmanFordAlgorithm.findEntity(50);
        System.out.println("Searched value: " + searchedEntityBellmanFordAlgorithm4.getValue() + ", path length: " + searchedEntityBellmanFordAlgorithm4.getPathLength());

        /*Floyd-Warshall algorithm*/
        System.out.println("--- Bellman–Ford algorithm ---");

        GraphWithFloydWarshallAlgorithm graphWithFloydWarshallAlgorithm = new GraphWithFloydWarshallAlgorithm();
        graphWithFloydWarshallAlgorithm.add(9);
        graphWithFloydWarshallAlgorithm.add(8);
        graphWithFloydWarshallAlgorithm.add(24);
        graphWithFloydWarshallAlgorithm.add(50);
        graphWithFloydWarshallAlgorithm.add(33);
        graphWithFloydWarshallAlgorithm.add(12);
        graphWithFloydWarshallAlgorithm.add(10);
        graphWithFloydWarshallAlgorithm.add(11);
        graphWithFloydWarshallAlgorithm.add(1);
        graphWithFloydWarshallAlgorithm.remove(8);
        graphWithFloydWarshallAlgorithm.remove(24);

        graphWithFloydWarshallAlgorithm.recountShortestPathsWithFloydWarshallAlgorithm();

        GraphWithFloydWarshallAlgorithm.Entity searchedEntityFloydWarshallAlgorithm = graphWithFloydWarshallAlgorithm.findEntity(33);
        System.out.println("Searched value: " + searchedEntityFloydWarshallAlgorithm.getValue() + ", path length: " + searchedEntityFloydWarshallAlgorithm.getPathLength());
        GraphWithFloydWarshallAlgorithm.Entity searchedEntityFloydWarshallAlgorithm2 = graphWithFloydWarshallAlgorithm.findEntity(1);
        System.out.println("Searched value: " + searchedEntityFloydWarshallAlgorithm2.getValue() + ", path length: " + searchedEntityFloydWarshallAlgorithm2.getPathLength());
        GraphWithFloydWarshallAlgorithm.Entity searchedEntityFloydWarshallAlgorithm3 = graphWithFloydWarshallAlgorithm.findEntity(12);
        System.out.println("Searched value: " + searchedEntityFloydWarshallAlgorithm3.getValue() + ", path length: " + searchedEntityFloydWarshallAlgorithm3.getPathLength());
        GraphWithFloydWarshallAlgorithm.Entity searchedEntityFloydWarshallAlgorithm4 = graphWithFloydWarshallAlgorithm.findEntity(50);
        System.out.println("Searched value: " + searchedEntityFloydWarshallAlgorithm4.getValue() + ", path length: " + searchedEntityFloydWarshallAlgorithm4.getPathLength());

        /*lab4*/
        System.out.println("--- Lab 4 ---");

        /*Prim algorithm*/
        System.out.println("--- Prim algorithm ---");

        GraphWithPrimAlgorithm graphWithPrimAlgorithm = new GraphWithPrimAlgorithm();
        graphWithPrimAlgorithm.add(9);
        graphWithPrimAlgorithm.add(8);
        graphWithPrimAlgorithm.add(24);
        graphWithPrimAlgorithm.add(50);
        graphWithPrimAlgorithm.add(33);
        graphWithPrimAlgorithm.add(12);
        graphWithPrimAlgorithm.add(10);
        graphWithPrimAlgorithm.add(11);
        graphWithPrimAlgorithm.add(1);
        graphWithPrimAlgorithm.remove(8);
        graphWithPrimAlgorithm.remove(24);

        graphWithPrimAlgorithm.reorganizeGraphToTree();

        System.out.println("Number of highs: " + graphWithPrimAlgorithm.goThroughGraphWidthFirst().size());
        System.out.println("Number of ribs: " + graphWithPrimAlgorithm.getRibs().size());

        /*Kruskal algorithm*/
        System.out.println("--- Kruskal algorithm ---");

        GraphWithKruskalAlgorithm graphWithKruskalAlgorithm = new GraphWithKruskalAlgorithm();
        graphWithKruskalAlgorithm.add(9);
        graphWithKruskalAlgorithm.add(8);
        graphWithKruskalAlgorithm.add(24);
        graphWithKruskalAlgorithm.add(50);
        graphWithKruskalAlgorithm.add(33);
        graphWithKruskalAlgorithm.add(12);
        graphWithKruskalAlgorithm.add(10);
        graphWithKruskalAlgorithm.add(11);
        graphWithKruskalAlgorithm.add(1);
        graphWithKruskalAlgorithm.remove(8);
        graphWithKruskalAlgorithm.remove(24);

        graphWithKruskalAlgorithm.reorganizeGraphToTree();

        System.out.println("Number of highs: " + graphWithKruskalAlgorithm.goThroughGraphWidthFirst().size());
        System.out.println("Number of ribs: " + graphWithKruskalAlgorithm.getRibs().size());
    }
}
