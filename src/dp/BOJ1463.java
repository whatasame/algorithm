package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init array data */
        int[] count = new int[N + 1];
        count[1] = 0; // end point

        /* Dynamic programing */
        for (int i = 2; i <= N; i++) {
            /* Select min of i-1, i/3, i/2 */
            count[i] = count[i - 1];
            if (i % 3 == 0) {
                count[i] = Math.min(count[i / 3], count[i]);
            }
            if (i % 2 == 0) {
                count[i] = Math.min(count[i / 2], count[i]);
            }
            count[i]++; // Increase count
        }

        /* Print result */
        System.out.println(count[N]);

        br.close();
    }
}