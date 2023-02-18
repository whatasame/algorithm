package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11722 {

    public static void main(String[] args) throws IOException {
        /* Init sequence  */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numStr = br.readLine();
        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(numStr, " ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        /* LDS algorithm */
        int[] LDS = new int[N];
        LDS[0] = 1;
        for (int i = 1; i < N; i++) {
            // Compute max of LDS[0, ..., i-1]
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (sequence[j] > sequence[i]) {
                    max = Math.max(LDS[j], max);
                }
            }
            LDS[i] = max + 1;
        }

        /* Print result */
        int result = 0;
        for (int length : LDS) {
            result = Math.max(result, length);
        }
        System.out.println(result);

        br.close();
    }

}
