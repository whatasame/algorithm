package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2225 {

    public static void main(String[] args) throws IOException {
        /* Read input N, K */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /* Create count array */
        int[][] count = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            count[i][1] = 1;
        }

        /* Compute count */
        for (int k = 2; k <= K; k++) {
            count[0][k] = count[0][k - 1];
            for (int i = 1; i <= N; i++) {
                count[i][k] = count[i - 1][k] + count[i][k - 1];
                count[i][k] %= 1000000000;
            }
        }

        /* Print result */
        System.out.println(count[N][K]);

        br.close();
    }


}
