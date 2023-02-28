package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

    private static final StringBuilder sb = new StringBuilder();
    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /* Read input data */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        /* Init undirected graph by adjacent matrix */
        graph = new int[N + 1][N + 1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            /* Edge (u, v)*/
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        /* Init checked array */
        visited = new boolean[N + 1];

        /* Depth First Search */
        Arrays.fill(visited, false); // Reset checked history
        dfs(V);

        sb.append('\n');

        /* Breadth First Search */
        Arrays.fill(visited, false); // Reset checked history
        bfs(V);

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    public static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        sb.append(v).append(' ');

        for (int i = 1; i < graph[v].length; i++) {
            if (graph[v][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        /* Init bfs queue */
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        sb.append(v).append(' ');

        /* BFS */
        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int i = 1; i < graph[vertex].length; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i).append(' ');
                }
            }
        }
    }

}
