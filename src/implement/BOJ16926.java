package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        /* Read input N, M, Q */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        /* Init array */
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* Rotate array */
        int maxStep = Math.min(N, M) / 2;
        while (Q-- > 0) {
            for (int step = 0; step < maxStep; step++) {
                rotate(step);
            }
        }

        /* Print arr */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    private static void rotate(int step) {
        int tmp = arr[step][step];

        rotateTop(step);
        rotateRight(step);
        rotateBottom(step);
        rotateLeft(step);

        arr[step + 1][step] = tmp;
    }

    private static void rotateLeft(int step) {
        int len = arr.length - 2 * step;
        for (int i = len - 1; i > 0; i--) {
            arr[step + i][step] = arr[step + i - 1][step];
        }
    }

    private static void rotateBottom(int step) {
        int len = arr[step].length - 2 * step;
        int row = arr.length - 1 - step;
        for (int i = len - 1; i > 0; i--) {
            arr[row][step + i] = arr[row][step + i - 1];
        }
    }

    private static void rotateRight(int step) {
        int len = arr.length - (2 * step);
        int col = arr[step].length - 1 - step;
        for (int i = 0; i < len - 1; i++) {
            arr[step + i][col] = arr[step + i + 1][col];
        }
    }

    private static void rotateTop(int step) {
        int len = arr[step].length - 2 * step;
        for (int i = 0; i < len - 1; i++) {
            arr[step][step + i] = arr[step][step + i + 1];
        }
    }
}
