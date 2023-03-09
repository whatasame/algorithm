package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1016 {
    public static void main(String[] args) throws IOException {
        /* Read input MIN, MAX */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final long MIN = Long.parseLong(st.nextToken());
        final long MAX = Long.parseLong(st.nextToken());

        /* Init isDivided array */
        int length = (int) (MAX - MIN + 1);
        boolean[] isDivided = new boolean[length];

        /* Check isDivided number */
        for (long i = 2; i * i <= MAX; i++) {
            /* Compute start number: minimum number which is first divided by squareNum between MIN and MAX */
            long squareNum = i * i;
            long quotient = MIN % squareNum == 0 ? MIN / squareNum : MIN / squareNum + 1;
            long start = squareNum * quotient;

            /* Check start, start + squareNum, start + squareNum + squareNum, ... */
            for (long num = start; num <= MAX; num += squareNum) {
                int idx = (int) (num - MIN);
                isDivided[idx] = true;
            }
        }

        /* Print result which is count of not divided number */
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!isDivided[i])
                count++;
        }

        System.out.println(count);
    }

}
