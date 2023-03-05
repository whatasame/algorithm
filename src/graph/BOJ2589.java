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

    private static final int[] offsetX = {0, 0, 1, -1};
    private static final int[] offsetY = {-1, 1, 0, 0};


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
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                /* Run BFS for all 'L' vertex */
                if (graph[i][j] == 'L') {
                    int length = bfs(new Vertex(i, j, 0));
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        /* Print result */
        System.out.println(maxLength);

        br.close();
    }

    public static int bfs(Vertex vertex) {
        /* BFS data */
        boolean[][] visited = new boolean[N][M];

        /* BFS queue */
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex.x][vertex.y] = true;

        /* BFS */
        int bfsLength = 0;
        while (!queue.isEmpty()) {
            /* Dequeue vertex */
            vertex = queue.poll();

            /* Search neighbor land */
            for (int i = 0; i < offsetX.length; i++) {
                int newX = vertex.x + offsetX[i];
                int newY = vertex.y + offsetY[i];
                int newLength = vertex.length + 1;

                if (isValid(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 'L') {
                    /* Enqueue neighbor land */
                    queue.offer(new Vertex(newX, newY, newLength));
                    visited[newX][newY] = true;

                    /* Update return length */
                    bfsLength = Math.max(bfsLength, newLength);
                }
            }
        }

        return bfsLength;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static class Vertex {

        int x;
        int y;

        int length;

        public Vertex(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
}


