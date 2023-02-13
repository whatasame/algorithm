package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {

    private static final int MAX_N = 1000;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Compute Nth number of case */
        int[] caseArr = new int[MAX_N + 1];
        caseArr[0] = 1;
        caseArr[1] = 1;
        for (int i = 2; i <= N; i++) {
            caseArr[i] = caseArr[i - 1] + caseArr[i - 2];
            caseArr[i] %= 10007;
        }

        /* Print result */
        System.out.println(caseArr[N]);

        br.close();
    }
}

