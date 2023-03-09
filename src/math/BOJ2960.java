package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2960 {

    public static void main(String[] args) throws IOException {
        /* Read input N, K */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        /* Run algorithm */
        solution(N, K);

        br.close();

    }

    public static void solution(int N, int K) {
        /* Init isDeleted array */
        boolean[] isDeleted = new boolean[N + 1]; // 0 to N

        /* Compute Kth deleted number */
        int deleteCount = 0;
        for (int i = 2; i <= N; i++) {
            /* Skip duplicated compute */
            if (isDeleted[i]) {
                continue;
            }

            /* Delete number */
            for (int targetNum = i; targetNum <= N; targetNum += i) {
                if (!isDeleted[targetNum]) {
                    isDeleted[targetNum] = true;
                    deleteCount++;
                }

                /* Print result */
                if (deleteCount == K) {
                    System.out.println(targetNum);
                    return;
                }
            }
        }
    }

}
