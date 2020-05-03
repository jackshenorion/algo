package algo.clrs.c22;

public class Solution22_1_6 {

    public static final int universalSink(int[][] graph) {
        int result = 0;
        for (int i = 1; i < graph.length; i ++) {
            if (graph[result][i] != 0) {
                result = i; // new vertex won
            }
        }
        for (int i = 0; i < graph.length; i++) { // check row
            if (graph[result][i] != 0) {
                return -1;
            }
        }
        for (int j = 0; j < graph.length; j++) { // check column
            if (graph[j][result] == 0 && j != result ) {
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Solution22_1_6.universalSink(
                new int[][]{
                        {0, 0, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0},
                        {0, 0, 1, 1}
                }
        ));

        System.out.println(Solution22_1_6.universalSink(
                new int[][]{
                        {0, 0, 1, 0},
                        {0, 1, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 1, 1}
                }
        ));
    }

}
