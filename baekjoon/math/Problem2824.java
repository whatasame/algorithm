package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Problem2824 {

    /*
     * https://www.acmicpc.net/problem/2824
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input data of A
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        BigInteger A = BigInteger.ONE;
        for (int i = 0; i < N; i++) {
            A = A.multiply(new BigInteger(st.nextToken()));
        }

        // Input data of B
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        BigInteger B = BigInteger.ONE;
        for (int i = 0; i < M; i++) {
            B = B.multiply(new BigInteger(st.nextToken()));
        }

        // get GCD
        BigInteger GCD = A.gcd(B);

        // print GCD
        String result = GCD.toString();
        if (result.length() > 9) {
            result = result.substring(result.length() - 9);
        }
        System.out.println(result);

        br.close();
    }

}
