package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1303 {

    private static int N;
    private static int M;

    private static char[][] ground;
    private static boolean[][] visited;

    private static final int[] offsetX = {0, 0, 1, -1};
    private static final int[] offsetY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        /* Read input N, M */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /* Init ground */
        ground = new char[M][N];
        for (int i = 0; i < M; i++) {
            ground[i] = br.readLine().toCharArray();
        }

        /* DFS about All vertex */
        int whitePower = 0;
        int bluePower = 0;
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    char color = ground[i][j];
                    int soldier = dfs(i, j, color);
                    int power = (int) Math.pow(soldier, 2);

                    if (color == 'W') {
                        whitePower += power;
                    } else {
                        bluePower += power;
                    }
                }
            }
        }

        /* Print result */
        System.out.println(whitePower + " " + bluePower);

        br.close();
    }

    private static int dfs(int x, int y, char color) {
        int soldier = 0;

        visited[x][y] = true;
        soldier++;

        for (int i = 0; i < offsetX.length; i++) {
            int newX = x + offsetX[i];
            int newY = y + offsetY[i];

            if (isValid(newX, newY) && !visited[newX][newY] && ground[newX][newY] == color) {
                soldier += dfs(newX, newY, color);
            }

        }

        return soldier;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

}
