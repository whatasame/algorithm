package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {

    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Read and init data array */
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* Run algorithm */
        countSquare(arr, 0, 0, N);

        /* Print result */
        System.out.println(white);
        System.out.println(blue);

        br.close();
    }

    private static void countSquare(int[][] arr, int row, int col, int length) {
        int baseColor = arr[row][col];

        if (length == 1) {
            if (baseColor == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (arr[i][j] != baseColor) {
                    countSquare(arr, row, col, length / 2);
                    countSquare(arr, row, col + length / 2, length / 2);
                    countSquare(arr, row + length / 2, col, length / 2);
                    countSquare(arr, row + length / 2, col + length / 2, length / 2);
                    return; // count nothing
                }
            }
        }

        /* All color in square is same */
        if (baseColor == 1) {
            blue++;
        } else {
            white++;
        }
    }
}
