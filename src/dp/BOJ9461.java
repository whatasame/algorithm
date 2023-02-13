package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {

    private static final int MAX_N = 100;

    public static void main(String[] args) throws IOException {
        /* Init data */
        long[] area = new long[MAX_N + 1];
        area[1] = area[2] = area[3] = 1;
        area[4] = area[5] = 2;
        for (int i = 6; i <= MAX_N; i++) {
            area[i] = area[i - 1] + area[i - 5];
        }

        /* Read input T */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* Print result */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(area[N]).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}
