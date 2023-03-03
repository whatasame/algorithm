package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

        /* Prepare for BFS */
        int inviteCount = 0;
        boolean[] invited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 2; i <= N; i++) { // invite friend
            if (graph[1][i]) {
                invited[i] = true;
                inviteCount++;
                queue.offer(i);
            }
        }

        /* Count friend of friend */
        while (!queue.isEmpty()) {
            int friend = queue.poll();
            for (int i = 2; i <= N; i++) {
                if (graph[friend][i] && !invited[i]) {
                    invited[i] = true;
                    inviteCount++;
                }
            }
        }

        /* Print result */
        System.out.println(inviteCount);

        br.close();
    }

}
