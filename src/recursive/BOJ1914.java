package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1914 {

    private static final StringBuilder sb = new StringBuilder();
    private static int moveCount = 0;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Branch by N */
        if (N <= 20) {
            /* Run algorithm */
            hanoiTower(N, 1, 3, 2);

            /* Print result */
            System.out.println(moveCount);
            System.out.println(sb);
        } else {
            BigInteger two = new BigInteger("2");
            BigInteger count = two.pow(N).subtract(BigInteger.ONE); // 2^N - 1

            /* Print result */
            System.out.println(count);
        }

        br.close();
    }

    /**
     * Append hanoi tower path if height of tower is less than or equal 20
     * and also increase moveCount by one
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
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }

        /* Recursive (Move N-1 tower) */
        hanoiTower(height - 1, from, tmp, to);
        sb.append(from).append(' ').append(to).append('\n');
        hanoiTower(height - 1, tmp, to, from);
    }
}
