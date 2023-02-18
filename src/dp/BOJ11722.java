package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int length = 0;
        LIS[0] = sequence[0];
        length++;
        for (int i = 1; i < N; i++) {
            if (LIS[length - 1] < sequence[i]) { // Check ascending order
                LIS[length] = sequence[i];
                length++;
            } else {
                /* Find lowerBound */
                int lowerBound = Arrays.binarySearch(LIS, 0, length, sequence[i]);
                if (lowerBound < 0) {
                    lowerBound = -lowerBound - 1;
                }

                LIS[lowerBound] = sequence[i];
            }
        }

        /* Print result */
        System.out.println(length);

        br.close();
    }

}
