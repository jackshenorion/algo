package algo.clrs.c22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution22_1_5 {

    public static final List<List<Integer>> squareGraph(List<List<Integer>> adjLists) {
        List<List<Integer>> result = new ArrayList<>();
        int[] neighborChecks = new int[adjLists.size()];
        for (int i = 0; i < neighborChecks.length; i++) {
            neighborChecks[i] = -1; // initialize to -1 before our vertex index starts from 0
        }
        for (int i = 0; i < adjLists.size(); i++) {
            List<Integer> neighbors = adjLists.get(i);
            List<Integer> newNeighbors = new ArrayList<>();
            result.add(newNeighbors);
            for (int neighbor : neighbors) {
                for (int nextNeighbor : adjLists.get(neighbor)) {
                    if (neighborChecks[nextNeighbor] != i && nextNeighbor != i) {
                        neighborChecks[nextNeighbor] = i;
                        newNeighbors.add(nextNeighbor);
                    }
                }
                if (neighborChecks[neighbor] != i) {
                    neighborChecks[neighbor] = i;
                    newNeighbors.add(neighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Solution22_1_5.squareGraph(Arrays.asList(
                Arrays.asList(2, 4),
                Arrays.asList(3, 4),
                Arrays.asList(1),
                Arrays.asList(0),
                Arrays.asList(),
                Arrays.asList()
        ));
        System.out.println(result);

        // result:
        // (2, 4, 1),
        // (3, 4, 0),
        // (1, 3, 4),
        // (0, 2, 4),
        // (),
        // ()
    }

}
