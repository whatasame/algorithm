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
        fillWhiteSpace(0, 0, N, false);

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

    private static void fillWhiteSpace(int row, int col, int length, boolean isCenter) {
        /* End of recursive */
        if (length < 1) {
            arr[row][col] = '*';
            return;
        }

        /* Fill center with whiteSpace */
        if (isCenter) {
            for (int i = row; i < row + length; i++) {
                for (int j = col; j < col + length; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) { // center
                    fillWhiteSpace(row + i * length / 3, col + j * length / 3, length / 3, true);
                    continue;
                }
                fillWhiteSpace(row + i * length / 3, col + j * length / 3, length / 3, false);
            }

        }
    }
}
