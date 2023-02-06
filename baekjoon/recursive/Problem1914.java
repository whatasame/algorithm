package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1914 {

    private static final StringBuilder sb = new StringBuilder();
    private static boolean genString; // Flag for string generation
    private static int moveCount = 0;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init flag */
        genString = N <= 20;

        /* Run algorithm */
        hanoiTower(N, 1, 3, 2);

        /* Print result */
        System.out.println(moveCount);
        System.out.println(sb);

        br.close();
    }

    /**
     * Append hanoi tower path if genString is true
     * Increase moveCount by one
     *
     * @param height height of tower
     * @param from   start rod
     * @param to     destination rod
     * @param tmp    temporal rod
     */
    private static void hanoiTower(int height, int from, int to, int tmp) {
        /* Increase count */
        moveCount++;

        if (height == 1) { // End of recursive
            if (genString) {
                sb.append(from).append(' ').append(to).append('\n');
            }
            return;
        }

        /* Recursive (Move N-1 tower) */
        hanoiTower(height - 1, from, tmp, to);
        if (genString) {
            sb.append(from).append(' ').append(to).append('\n');
        }
        hanoiTower(height - 1, tmp, to, from);
    }
}
