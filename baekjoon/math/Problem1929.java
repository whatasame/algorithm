package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1929 {

    /*
     * https://www.acmicpc.net/problem/1929
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        /*
         * Default init value for boolean array is false
         * true = not prime number
         * false = prime number
         * */
        boolean[] numArr = new boolean[N + 1];
        numArr[0] = numArr[1] = true;

        // Check prime number
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (numArr[i] == true) {
                /*
                 * if number is not prime, multiple of number is true already
                 * e.g. if 4 is true, a multiple of four (4, 8, ...) is also already true
                 * because when i == 2, a multiple of two (2, 4, 6, 8, ...) is true
                 * */
                break;
            }

            for (int j = 2; j <= N / i; j++) {
                /*
                 * j = 2 : not except themselves
                 * N / i : count of multiple. e.g. if i is 100, multiple is 50 (2, 4, 6, ..., 100)
                 * */
                numArr[i * j] = true; // only except multiple of prime number
            }
        }

        // Print Result
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (numArr[i] == false) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);

        br.close();
    }
}

