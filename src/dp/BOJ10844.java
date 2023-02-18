package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {

    public static void main(String[] args) throws IOException {
        /* Init data */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10];
        for (int i = 1; i < 10; i++) {
            count[i] = 1;
        }

        /* Compute cases */
        for (int i = 2; i <= N; i++) {
            int[] tmp = new int[10];
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                if (j > 0) {
                    sum += count[j - 1];
                }
                if (j < 9) {
                    sum += count[j + 1];

                }
                tmp[j] = sum % 1000000000;
            }
            count = tmp;
        }

        /* Print result */
        int result = 0;
        for (int c : count) {
            result += c % 1000000000;
        }
        System.out.println(result);

        br.close();
    }
}
