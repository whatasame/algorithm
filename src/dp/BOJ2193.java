package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init array */
        long[] endWithOne = new long[N + 1];
        long[] endWithZero = new long[N + 1];
        endWithZero[1] = 0;
        endWithOne[1] = 1;
        for (int i = 2; i <= N; i++) {
            endWithZero[i] = endWithZero[i - 1] + endWithOne[i - 1];
            endWithOne[i] = endWithZero[i - 1];
        }

        /* Print result */
        System.out.println(endWithOne[N] + endWithZero[N]);

        br.close();
    }
}
