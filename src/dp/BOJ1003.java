package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {

    private static final int MAX_N = 40;

    public static void main(String[] args) throws IOException {
        /* Read input T */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* Init count data */
        int[] zeroCount = new int[MAX_N + 1];
        int[] oneCount = new int[MAX_N + 1];
        zeroCount[0] = 1;
        oneCount[0] = 0;
        zeroCount[1] = 0;
        oneCount[1] = 1;
        for (int i = 2; i <= MAX_N; i++) {
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
        }

        /* Print result */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zeroCount[N]).append(' ').append(oneCount[N]).append('\n');
        }
        System.out.println(sb);


        br.close();
    }
}
