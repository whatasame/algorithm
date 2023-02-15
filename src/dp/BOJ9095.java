package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {

    public static void main(String[] args) throws IOException {
        /* Init case data */
        int MAX_N = 10;
        int[] count = new int[MAX_N + 1];
        count[1] = 1;
        count[2] = 2;
        count[3] = 4;
        for (int i = 4; i <= MAX_N; i++) {
            count[i] = count[i - 1] + count[i - 2] + count[i - 3];
        }

        /* Read input T */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* Print result */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(count[N]).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

}
