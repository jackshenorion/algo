package algo.clrs.c22;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Solution22_2_4 {

    // use Figure22.2(a)

    public static final void bfs(List<List<Integer>> g, int s) {
        int[] c = new int[g.size()]; // 0: white, 1: gray, 2: black
        int[] d = new int[g.size()];
        int[] p = new int[g.size()];

        for (int i = 0; i < g.size(); i++) {
            d[i] = -1;
            p[i] = -1;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        c[s] = 1;
        d[s] = 0;
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            for (Integer v : g.get(u)) {
                if (c[v] == 0) {
                    queue.offer(v);
                    c[v] = 1;
                    d[v] = d[u] + 1;
                    p[v] = u;
                }
            }
            c[u] = 2;
        }
        System.out.println("color: " + Arrays.toString(c));
        System.out.println("distance: " + Arrays.toString(d));
        System.out.println("parent: " + Arrays.toString(p));
    }

    public static final void bfs(int[][] g, int s) {
        int[] c = new int[g.length]; // 0: white, 1: gray, 2: black
        int[] d = new int[g.length];
        int[] p = new int[g.length];

        for (int i = 0; i < g.length; i++) {
            d[i] = -1;
            p[i] = -1;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        c[s] = 1;
        d[s] = 0;

        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            for (int i = 0; i < g.length; i++) {
                if (g[u][i] == 1 && c[i] == 0) {
                    queue.offer(i);
                    c[i] = 1;
                    d[i] = d[u] + 1;
                    p[i] = u;
                }
                c[u] = 2;
            }
        }

        System.out.println("color: " + Arrays.toString(c));
        System.out.println("distance: " + Arrays.toString(d));
        System.out.println("parent: " + Arrays.toString(p));
    }

    public static void main(String[] args) {
        List<List<Integer>> adjLists = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(2, 4),
                Arrays.asList(5),
                Arrays.asList(5, 6),
                Arrays.asList(2),
                Arrays.asList(4),
                Arrays.asList(6)
        );

        int[][] adjMatrix = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1}
        };

        Solution22_2_4.bfs(adjLists, 3);
        Solution22_2_4.bfs(adjMatrix, 3);

        //**d:** <br/>
        //1:infinite<br/>
        //2:3<br/>
        //3:0<br/>
        //4:2<br/>
        //5,6:1<br/>
        //
        //**parent** <br/>
        //1: nil<br/>
        //2: 4<br/>
        //3: nil<br/>
        //4: 5<br/>
        //5: 3<br/>
        //6: 3<br/>
    }

}
