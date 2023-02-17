package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {

    public static void main(String[] args) throws IOException {
        /* Read input data */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String numStr = br.readLine();

        /* Create sequence */
        int[] sequence = new int[size];
        StringTokenizer st = new StringTokenizer(numStr, " ");
        for (int i = 0; i < size; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        /* LIS algorithm */
        int[] LIS = new int[size];
        LIS[0] = 1;
        for (int i = 0; i < size; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    max = Math.max(LIS[j], max);
                    LIS[i] = max + 1;
                }
            }
        }

        /* Print result */
        int result = 0;
        for (int length : LIS) {
            result = Math.max(length, result);
        }
        System.out.println(result);

        br.close();
    }
}
