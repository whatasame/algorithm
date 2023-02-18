package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {

    private static final int MOD_VALUE = 10007;

    public static void main(String[] args) throws IOException {
        /* Read data */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init data */
        int[][] count = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            count[1][i] = 1;
        }

        /* Compute count of case */
        for (int digit = 2; digit <= N; digit++) {
            for (int i = 0; i <= 9; i++) {
                int sum = 0;
                for (int j = 0; j <= i; j++) {
                    sum += count[digit - 1][j];
                    sum %= MOD_VALUE;
                }
                count[digit][i] = sum;
            }
        }

        /* Print result */
        int result = 0;
        for (int cnt : count[N]) {
            result += cnt;
            result %= 10007;
        }
        System.out.println(result);

        br.close();
    }
}
