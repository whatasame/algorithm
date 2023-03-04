package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {

    private static int W;
    private static int H;

    private static int[][] map;

    private static boolean[][] visited;

    private static final int[] offsetX = {0, 0, -1, 1, -1, 1, -1, 1};
    private static final int[] offsetY = {-1, 1, 0, 0, -1, -1, 1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            /* Read input W, H */
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) { // break condition of while
                break;
            }

            /* Init map */
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            /* DFS */
            visited = new boolean[H][W];
            int islandCount = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        islandCount++;
                    }
                }
            }

            /* Print result */
            System.out.println(islandCount);
        }
        br.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        /* DFS about 8 direction of vertex(x, y) */
        for (int i = 0; i < offsetX.length; i++) {
            int newX = x + offsetX[i];
            int newY = y + offsetY[i];

            /* Check valid vertex */
            if (isValidIndex(newX, newY) && !visited[newX][newY] && map[newX][newY] == 1) {
                dfs(newX, newY);
            }

        }

    }

    public static boolean isValidIndex(int x, int y) {
        return (x >= 0 && y >= 0 && x < H && y < W);
    }

}
