package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {

    public static void main(String[] args) throws IOException {
        /* Read sequence data */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numStr = br.readLine();

        /* Create sequence */
        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(numStr, " ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        /* Compute continuous sum */
        int[] sum = new int[N];
        int result = sum[0] = sequence[0];
        for (int i = 1; i < N; i++) {
            sum[i] = Math.max(sum[i - 1] + sequence[i], sequence[i]);
            result = Math.max(sum[i], result);
        }

        /* Print result */
        System.out.println(result);

        br.close();
    }


}
