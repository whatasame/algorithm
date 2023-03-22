package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {

    private static final int MODULO_NUM = 9901;

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
            int befCount = count[i - 1][0] + count[i - 1][1] + count[i - 1][2];

            count[i][0] = befCount % MODULO_NUM;
            count[i][1] = (befCount - count[i - 1][1]) % MODULO_NUM;
            count[i][2] = (befCount - count[i - 1][2]) % MODULO_NUM;
        }

        /* Print result */
        int result = count[N][0] + count[N][1] + count[N][2];
        System.out.println(result % MODULO_NUM);

        br.close();
    }
}
