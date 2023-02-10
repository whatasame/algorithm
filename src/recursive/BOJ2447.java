package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {

    private static char[][] arr;


    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Create array instance */
        arr = new char[N][N];

        /* Run recursive */
        fillArr(0, 0, N, false);

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

    private static void fillArr(int row, int col, int length, boolean whiteSpace) {
        /* End of recursive */
        if (length < 1) {
            arr[row][col] = '*';
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
        fillArr(row, col, length / 3, false);
        fillArr(row, col + length / 3, length / 3, false);
        fillArr(row, col + 2 * length / 3, length / 3, false);

        /* Middle */
        fillArr(row + length / 3, col, length / 3, false);
        fillArr(row + length / 3, col + length / 3, length / 3, true);
        fillArr(row + length / 3, col + 2 * length / 3, length / 3, false);

        /* Bottom */
        fillArr(row + 2 * length / 3, col, length / 3, false);
        fillArr(row + 2 * length / 3, col + length / 3, length / 3, false);
        fillArr(row + 2 * length / 3, col + 2 * length / 3, length / 3, false);
    }
}
