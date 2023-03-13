package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1850 {

    public static void main(String[] args) throws IOException {
        /* Read input A, B */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final long A = Long.parseLong(st.nextToken());
        final long B = Long.parseLong(st.nextToken());

        /* Compute GCD(A, B) */
        long gcd = getGcd(A, B);

        /* Print result */
        System.out.println(getResult(gcd));

        br.close();
    }

    public static long getGcd(long a, long b) {
        /* Euclid algorithm */
        if (a % b == 0) {
            return b;
        }

        return getGcd(b, a % b);
    }

    public static String getResult(long gcd) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd; i++) {
            sb.append(1);
        }
        return sb.toString();
    }
}
