package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {

    private static int N;
    private static int M;

    private static char[][] graph;
    private static boolean[][] visited;
    private static int[][] bfsLength;

    private static final int[] offsetX = {0, 0, 1, -1};
    private static final int[] offsetY = {-1, 1, 0, 0};

    private static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        /* Read input N, M */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /* Init graph */
        graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        /* Compute maxLength */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                /* Run BFS for all vertex */
                visited = new boolean[N][M];
                bfsLength = new int[N][M];
                bfs(new Vertex(i, j));
            }
        }

        /* Print result */
        System.out.println(maxLength);

        br.close();
    }

    public static void bfs(Vertex vertex) {
        /* BFS queue */
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(vertex);

        /* BFS */
        while (!queue.isEmpty()) {
            /* Dequeue vertex */
            vertex = queue.poll();
            int x = vertex.x;
            int y = vertex.y;
            visited[x][y] = true;

            /* Search neighbor land */
            for (int i = 0; i < offsetX.length; i++) {
                int newX = x + offsetX[i];
                int newY = y + offsetY[i];

                if (isValid(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 'L') {
                    /* Enqueue neighbor land */
                    queue.offer(new Vertex(newX, newY));

                    /* Length and result update */
                    bfsLength[newX][newY] = bfsLength[x][y] + 1;
                    maxLength = Math.max(maxLength, bfsLength[newX][newY]);
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static class Vertex {

        int x;
        int y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


