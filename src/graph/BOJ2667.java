package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ2667 {

    private static int[][] graph;
    private static boolean[][] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init graph */
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String dataStr = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Character.getNumericValue(dataStr.charAt(j));
            }

        }

        /* Run DFS */
        int result = 0;
        visited = new boolean[N][N];
        Queue<Integer> countMinHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                dfs(i, j);
                if (count != 0) {
                    result++;
                    countMinHeap.offer(count);
                }
            }
        }
        
        /* Print result */
        System.out.println(result);
        while (!countMinHeap.isEmpty()) {
            System.out.println(countMinHeap.poll());
        }

        br.close();
    }

    public static void dfs(int x, int y) {
        if (x < 0 || x >= graph.length || y < 0 || y >= graph[x].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        if (graph[x][y] == 0) {
            return;
        }

        visited[x][y] = true;
        count++;

        dfs(x, y + 1);
        dfs(x, y - 1);
        dfs(x - 1, y);
        dfs(x + 1, y);
    }
}
