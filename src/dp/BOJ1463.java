package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Run algorithm */
        int[] count = new int[N + 1];
        count[1] = 0;
        for (int i = 2; i <= N; i++) {
            count[i] = count[i - 1] + 1;
            if (i % 3 == 0) {
                count[i] = Math.min(count[i / 3] + 1, count[i]);
            }
            if (i % 2 == 0) {
                count[i] = Math.min(count[i / 2] + 1, count[i]);
            }
        }

        /* Print result */
        System.out.println(count[N]);

        br.close();
    }
}