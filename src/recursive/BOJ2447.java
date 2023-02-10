package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {


    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init array */
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = '*';
            }
        }

        /* Run recursive */
        fillArr(arr, 0, 0, N, false);

        /* Print result */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    private static void fillArr(char[][] arr, int row, int col, int length, boolean whiteSpace) {
        /* End of recursive */
        if (length < 1) {
            return;
        }

        if (whiteSpace) {
            for (int i = row; i < row + length; i++) {
                for (int j = col; j < col + length; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        /* Top */
        fillArr(arr, row, col, length / 3, false);
        fillArr(arr, row, col + length / 3, length / 3, false);
        fillArr(arr, row, col + 2 * length / 3, length / 3, false);

        /* Middle */
        fillArr(arr, row + length / 3, col, length / 3, false);
        fillArr(arr, row + length / 3, col + length / 3, length / 3, true);
        fillArr(arr, row + length / 3, col + 2 * length / 3, length / 3, false);

        /* Bottom */
        fillArr(arr, row + 2 * length / 3, col, length / 3, false);
        fillArr(arr, row + 2 * length / 3, col + length / 3, length / 3, false);
        fillArr(arr, row + 2 * length / 3, col + 2 * length / 3, length / 3, false);
    }
}
