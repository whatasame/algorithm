package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {

    private static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        /* Init dp array */
        int[][] count = new int[N + 1][3];
        count[1][0] = 1;
        count[1][1] = 1;
        count[1][2] = 1;

        /* Dynamic programing */
        for (int i = 2; i <= N; i++) {
            count[i][0] = (count[i - 1][0] + count[i - 1][1] + count[i - 1][2]) % MOD;
            count[i][1] = (count[i - 1][0] + count[i - 1][2]) % MOD;
            count[i][2] = (count[i - 1][0] + count[i - 1][1]) % MOD;
        }

        /* Print result */
        int result = (count[N][0] + count[N][1] + count[N][2]) % MOD;
        System.out.println(result);

        br.close();
    }
}
