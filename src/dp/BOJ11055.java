package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {

    public static void main(String[] args) throws IOException {
        /* Init sequence */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numStr = br.readLine();

        /* Create sequence */
        StringTokenizer st = new StringTokenizer(numStr, " ");
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        /* LIS algorithm */
        int[] LIS = new int[N]; // sum of LIS[i]
        LIS[0] = sequence[0];
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    max = Math.max(LIS[j], max);
                }
            }
            LIS[i] = max + sequence[i];
        }

        /* Print result */
        int result = 0;
        for (int sum : LIS) {
            result = Math.max(sum, result);
        }
        System.out.println(result);

        br.close();
    }
}
