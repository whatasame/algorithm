package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17103 {

    /*
     * https://www.acmicpc.net/problem/17103
     * */

    public static boolean[] isNotPrime = new boolean[1000001];  // default value : false -> isPrime. true -> isNotPrime

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input T
        int T = Integer.parseInt(br.readLine());

        // Run for N pieces data
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int count = getPartitionCount(N);

            sb.append(count).append('\n');
        }

        // Print result
        System.out.print(sb);

        br.close();
    }

    private static int getPartitionCount(int N) {
        // Get prime number list
        getPrimeNumList(N);

        // Find count of partition
        int count = 0;
        for (int i = 2; i <= N / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[N - i]) {
                count++;
            }
        }

        return count;
    }

    private static void getPrimeNumList(int N) {
        // sieve of Eratosthenes
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (isNotPrime[i] == true) {
                continue;
            }

            for (int j = 2; j <= N / i; j++) {
                isNotPrime[i * j] = true;
            }
        }

    }
}