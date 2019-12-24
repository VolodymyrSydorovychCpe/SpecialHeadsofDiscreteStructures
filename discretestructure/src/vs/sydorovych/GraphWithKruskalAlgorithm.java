package vs.sydorovych;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GraphWithKruskalAlgorithm extends Graph<Integer> {

    public void reorganizeGraphToTree() {
        List<Pair<Entity, Entity>> ribs = getRibs();
        ribs.sort(Comparator.comparingInt(rib -> (int) rib.getValue().getValue()));

        ribs.forEach(rib -> {
            if (rib.getValue().isPassed) {
                if (rib.getKey().left.getValue().equals(rib.getValue().getValue())) {
                    rib.getKey().left = null;
                } else if (rib.getKey().right.getValue().equals(rib.getValue().getValue())) {
                    rib.getKey().right = null;
                }
            } else {
                rib.getValue().isPassed = true;
            }
        });
    }
}
