package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11722 {

    public static void main(String[] args) throws IOException {
        /* Init reverse sequence  */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numStr = br.readLine();
        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(numStr, " ");
        for (int i = N - 1; i >= 0; i--) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        /* LIS algorithm */
        int[] LIS = new int[N];
        LIS[0] = 1;
        for (int i = 1; i < N; i++) {
            // Compute max of LIS[0, ..., i-1]
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    max = Math.max(LIS[j], max);
                }
            }
            LIS[i] = max + 1;
        }

        /* Print result */
        int result = 0;
        for (int length : LIS) {
            result = Math.max(result, length);
        }
        System.out.println(result);

        br.close();
    }

}
