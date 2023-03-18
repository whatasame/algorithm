package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

    private static int r;
    private static int c;

    private static boolean isFound = false;
    private static int count = -1;
    private static final int[] offsetRow = {0, 0, 1, 1};
    private static final int[] offsetCol = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        /* Read input N, r, c */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        /* Visit recursively */
        int length = (int) Math.pow(2, N);
        visit(0, 0, length);

        /* Print result */
        System.out.println(count);

        br.close();
    }

    private static void visit(int row, int col, int length) {
        if (isFound) {
            return;
        }

        if (length <= 2) {
            for (int i = 0; i < offsetCol.length; i++) {
                count++;

                int newRow = row + offsetRow[i];
                int newCol = col + offsetCol[i];

                if (newRow == r && newCol == c) {
                    isFound = true;
                    return;
                }
            }
            return;
        }


        length /= 2;
        if (row + length <= r && col + length <= c) {
            count += (int) Math.pow(length, 2) * 3;
            visit(row + length, col + length, length);
        } else if (row + length <= r && col <= c) {
            count += (int) Math.pow(length, 2) * 2;
            visit(row + length, col, length);
        } else if (row <= r && col + length <= c) {
            count += (int) Math.pow(length, 2);
            visit(row, col + length, length);
        } else {
            visit(row, col, length);
        }
    }
}
