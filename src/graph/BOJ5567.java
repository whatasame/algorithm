package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5567 {

    public static void main(String[] args) throws IOException {
        /* Read input N, M */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        /* Init undirected graph */
        boolean[][] graph = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            /* Read edge(u, v) */
            StringTokenizer relationStr = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(relationStr.nextToken());
            int v = Integer.parseInt(relationStr.nextToken());

            /* Add edge(u, v) */
            graph[u][v] = graph[v][u] = true;
        }

        /* Compute count of invited friend */
        int count = 0;
        boolean[] invited = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (graph[1][i]) { // 1 and i is friend
                if (!invited[i]) { // invite i
                    invited[i] = true;
                    count++;
                }

                for (int j = 2; j <= N; j++) {
                    if (graph[i][j]) { // j is i's friend
                        if (!invited[j]) { // invite j
                            invited[j] = true;
                            count++;
                        }
                    }
                }

            }
        }

        /* Print result */
        System.out.println(count);

        br.close();
    }


}
