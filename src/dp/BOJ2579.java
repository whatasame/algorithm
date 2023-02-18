package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Create stair array */
        int[] stair = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        /* Compute sum */
        int result;
        int[] sum = new int[N + 1];
        if (N == 1) {
            result = stair[1];
        } else {
            sum[0] = 0; // start point
            sum[1] = stair[1]; // move 1
            sum[2] = stair[1] + stair[2]; // move 1-1
            for (int i = 3; i <= N; i++) {
                sum[i] = Math.max(sum[i - 2], sum[i - 3] + stair[i - 1]) + stair[i]; // move ?-2 or 2-1
            }

            result = sum[N];
        }

        /* Print result */
        System.out.println(result);

        br.close();
    }
}
