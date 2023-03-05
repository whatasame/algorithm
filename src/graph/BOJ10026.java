package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {

    private static int N;

    private static char[][] graph;
    private static boolean[][] visited;

    private static final int[] offsetX = {0, 0, 1, -1};
    private static final int[] offsetY = {-1, 1, 0, 0};

    private static int notColorWeakCnt = 0;
    private static int colorWeakCnt = 0;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        /* Init graph */
        graph = new char[N][N];
        for (int i = 0; i < N; i++) {
            String graphStr = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = graphStr.charAt(j);
            }
        }

        /* Compute not color weakness area */
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    notColorWeakCnt++;
                }

            }
        }

        /* Create color weakness graph from original */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        /* Compute color weakness area */
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    colorWeakCnt++;
                }
            }
        }

        /* Print result */
        System.out.println(notColorWeakCnt + " " + colorWeakCnt);


        br.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < offsetX.length; i++) {
            /* Compute newVertex(newX, newY) */
            int newX = x + offsetX[i];
            int newY = y + offsetY[i];

            if (isValid(newX, newY) && !visited[newX][newY] && graph[newX][newY] == graph[x][y]) {
                dfs(newX, newY);
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}

