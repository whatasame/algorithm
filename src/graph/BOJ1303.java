package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1303 {

    private static int N;
    private static int M;

    private static char[][] ground;
    private static boolean[][] visited;

    private static final int[] offsetX = {0, 0, 1, -1};
    private static final int[] offsetY = {1, -1, 0, 0};

    private static final Map<Character, Integer> power = new HashMap<>();
    private static int count = 0;

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
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    char color = ground[i][j];
                    dfs(i, j, color);
                    power.put(color, power.getOrDefault(color, 0) + (int) Math.pow(count, 2));
                    count = 0;
                }
            }
        }

        /* Print result */
        System.out.println(power.getOrDefault('W', 0) + " " + power.getOrDefault('B', 0));


        br.close();
    }

    private static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < offsetX.length; i++) {
            int newX = x + offsetX[i];
            int newY = y + offsetY[i];

            if (isValid(newX, newY) && !visited[newX][newY] && ground[newX][newY] == color) {
                dfs(newX, newY, color);
            }

        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

}
