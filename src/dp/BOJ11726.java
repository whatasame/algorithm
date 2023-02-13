package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ11726 {

    private static final int MAX_N = 1000;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Compute Nth number of case */
        BigInteger[] caseArr = new BigInteger[MAX_N + 1];
        caseArr[1] = new BigInteger("1");
        caseArr[2] = new BigInteger("2");
        for (int i = 3; i <= N; i++) {
            caseArr[i] = caseArr[i - 1].add(caseArr[i - 2]);
        }

        /* Print result */
        System.out.println(caseArr[N].mod(new BigInteger("10007")));

        br.close();
    }
}
