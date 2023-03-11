package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953 {

    public static void main(String[] args) throws IOException {
        /* Read input A, B */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        /* Compute count of operation */
        int num = B;
        int count = 0;
        while (num > A) {
            if (num % 10 == 1) {
                num /= 10;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                break;
            }

            count++;
        }

        /* Print result */
        System.out.println(num == A ? count + 1 : -1);
    }

}
