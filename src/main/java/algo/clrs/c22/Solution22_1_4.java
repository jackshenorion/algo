package algo.clrs.c22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution22_1_4 {

    public static List<List<Integer>> reduceEdges(List<List<Integer>> adjList) {
        List<List<Integer>> result = new ArrayList<>();
        int[] matrix = new int[adjList.size()];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = -1;
        }
        for (int i = 0; i < adjList.size(); i++) {
            ArrayList<Integer> l = new ArrayList<>();
            result.add(l);
            List<Integer> neighbors = adjList.get(i);
            for (Integer neighbor : neighbors) {
                if (neighbor == i) {
                    continue; // remove loop
                } else if (matrix[neighbor] == i) {
                    continue; // neighbor has existed
                } else {
                    // new target vertex, set adjacent matrix as source vertex index
                    matrix[neighbor] = i;
                    l.add(neighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Solution22_1_4.reduceEdges(Arrays.asList(
                Arrays.asList(1, 2, 0, 2, 3),
                Arrays.asList(2, 4, 3, 1),
                Arrays.asList(1),
                Arrays.asList(),
                Arrays.asList(3, 3, 3, 3)
        ));
        System.out.println(result);

        // result:
        // [
        // [1, 2, 3],
        // [2, 4, 3],
        // [1],
        // [],
        // [3]
        // ]
    }
}
