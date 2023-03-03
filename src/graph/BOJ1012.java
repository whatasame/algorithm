package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {

    private static boolean[][] graph;
    private static boolean[][] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        /* Read input T */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* Compute test case */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            /* Read input M, N, K */
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            /* Init graph */
            graph = new boolean[N][M];
            while (K-- > 0) {
                /* Read x, y */
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                /* Add edge(u, v) to graph */
                graph[x][y] = true;
            }

            /* Run DFS */
            int result = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    count = 0;
                    dfs(i, j);
                    if (count != 0) {
                        result++;
                    }
                }
            }

            sb.append(result).append('\n');
        }

        /* Print result */
        System.out.print(sb);

        br.close();
    }

    public static void dfs(int x, int y) {
        if (x < 0 || x >= graph.length || y < 0 || y >= graph[x].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        if (!graph[x][y]) {
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
