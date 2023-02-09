package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {

    private static int moveCount = 0;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Run algorithm */
        hanoiTower(N, 1, 3, 2);

        /* Print result */
        System.out.println(moveCount);
        System.out.println(sb);

        br.close();
    }

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
