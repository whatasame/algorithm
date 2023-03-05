package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

    private static int N;
    private static int M;

    private static int[][] graph;

    private static boolean[][] visited;

    private static final int[] offsetX = {0, 0, -1, 1};
    private static final int[] offsetY = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        /* Read input N, M */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /* Init graph */
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String graphStr = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = graphStr.charAt(j) - '0';
            }
        }

        /* Prepare BFS */
        Queue<Vertex> queue = new LinkedList<>();
        visited = new boolean[N][M];

        /* BFS(1, 1) */
        queue.offer(new Vertex(0, 0));
        while (!queue.isEmpty()) {
            /* Dequeue vertex(x, y) */
            Vertex vertex = queue.poll();
            int x = vertex.x;
            int y = vertex.y;

            /* Reach end point */
            if (x == N - 1 && y == M - 1) {
                break;
            }

            /* Visit vertex(x, y) */
            visited[x][y] = true;

            /* BFS about 4 direction */
            for (int i = 0; i < offsetX.length; i++) {
                int newX = x + offsetX[i];
                int newY = y + offsetY[i];

                if (isValidPosition(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 1) {
                    /* Enqueue neighbor vertex */
                    queue.offer(new Vertex(newX, newY));

                    graph[newX][newY] = graph[x][y] + 1; // length++;
                }
            }
        }

        /* Print result */
        System.out.println(graph[N - 1][M - 1]);

        br.close();
    }

    public static boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    static class Vertex {
        int x;
        int y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

