package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init triangle array */
        int[][] triangle = new int[N][];
        for (int i = 0; i < N; i++) {
            /* Create data array */
            String numStr = br.readLine();
            int size = i + 1;
            int[] data = new int[size];
            StringTokenizer st = new StringTokenizer(numStr, " ");
            for (int j = 0; j < size; j++) {
                data[j] = Integer.parseInt(st.nextToken());
            }

            triangle[i] = data; // Insert data to triangle
        }

        /* Create sum array */
        int[][] sum = new int[N][];
        for (int i = 0; i < N; i++) {
            sum[i] = new int[i + 1];
        }

        /* Compute sum */
        sum[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int befMax;

                if (j == 0) {
                    befMax = sum[i - 1][j];
                } else if (j == i) {
                    befMax = sum[i - 1][j - 1];
                } else {
                    befMax = Math.max(sum[i - 1][j], sum[i - 1][j - 1]);
                }

                sum[i][j] = befMax + triangle[i][j];
            }
        }

        /* Print result */
        int result = 0;
        for (int i = 0; i < sum[N - 1].length; i++) {
            result = Math.max(sum[N - 1][i], result);
        }
        System.out.println(result);

        br.close();
    }
}
