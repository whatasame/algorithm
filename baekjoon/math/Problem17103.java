package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17103 {

    /*
     * https://www.acmicpc.net/problem/17103
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input T and N pieces of data
        int T = Integer.parseInt(br.readLine());
        int[] NList = new int[T];
        for (int i = 0; i < T; i++) {
            NList[i] = Integer.parseInt(br.readLine());
        }

        // Compute count of partition each number
        for (int N : NList) {
            System.out.println(getPartitionCount(N));
        }

        br.close();
    }

    private static int getPartitionCount(int N) {
        // Get prime number list
        boolean[] isNotPrime = getPrimeNumList(N);

        // Find count of partition
        int count = 0;
        for (int i = 2; i <= N / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[N - i]) {
                count++;
            }
        }

        return count;
    }

    private static boolean[] getPrimeNumList(int N) {
        // sieve of Eratosthenes
        boolean[] isNotPrime = new boolean[N + 1]; // default value : false -> isPrime. true -> isNotPrime
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isNotPrime[i] == true) {
                continue;
            }

            for (int j = 2; j <= N / i; j++) {
                isNotPrime[i * j] = true;
            }
        }

        return isNotPrime;
    }
}
