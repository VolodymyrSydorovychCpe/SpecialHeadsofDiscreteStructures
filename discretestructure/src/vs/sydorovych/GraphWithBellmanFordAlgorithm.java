package vs.sydorovych;

import javafx.util.Pair;
import org.omg.CORBA.BooleanHolder;

import java.util.List;

public class GraphWithBellmanFordAlgorithm extends Graph<Integer> {

    public void recountShortestPathsWithBellmanFordAlgorithm() {
        graphHigh.pathLength = 0;
        List<Pair<Entity, Entity>> ribs = getRibs();
        BooleanHolder wasChanged = new BooleanHolder(true);

        while (wasChanged.value) {
            wasChanged.value = false;
            ribs.forEach(rib -> {
                if (rib.getKey().pathLength != Integer.MAX_VALUE
                        && rib.getKey().pathLength + (int) rib.getValue().getValue() < rib.getValue().pathLength) {
                    rib.getValue().pathLength = rib.getKey().pathLength + (int) rib.getValue().getValue();
                    wasChanged.value = true;
                }
            });
        }
    }
}
