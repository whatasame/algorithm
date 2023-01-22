package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> primeNumList =  getPrimeNumList(N);

        // Find count of partition
        int count = 0;
        for (int i = 0; i < primeNumList.size(); i++) {
            for (int j = i; j < primeNumList.size(); j++) {
                int num1 = primeNumList.get(i);
                int num2 = primeNumList.get(j);

                if(num1 + num2 == N){
                    count++;
                }
            }

        }

        return count;
    }

    private static List<Integer> getPrimeNumList(int N) {
        // sieve of Eratosthenes
        boolean[] isNotPrime = new boolean[N + 1]; // default value : false -> isPrime. true -> isNotPrime
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(isNotPrime[i] == true){
                continue;
            }

            for (int j = 2; j <= N / i; j++) {
                isNotPrime[i * j] = true;
            }
        }

        // Generate prime number list of N
        List<Integer> primeNumList = new ArrayList<>();
        for (int i = 0; i < isNotPrime.length; i++) {
            if(isNotPrime[i] == false){
                primeNumList.add(i);
            }
        }

        return primeNumList;
    }
}
