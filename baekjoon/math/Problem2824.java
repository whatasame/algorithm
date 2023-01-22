package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2824 {

    /*
     * https://www.acmicpc.net/problem/2824
     * */

    public static Map<Integer, Integer> primeCountOfA = new HashMap<>(); // prime factorization of A

    public static Map<Integer, Integer> primeCountOfB = new HashMap<>(); // prime factorization of B


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input data of A
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> numListA = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            numListA.add(Integer.valueOf(st.nextToken()));
        }

        // Input data of B
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> numListB = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            numListB.add(Integer.valueOf(st.nextToken()));
        }

        // Prime factorization
        for (Integer num : numListA) {
            setPrimeCountMap(primeCountOfA, num);
        }
        for (Integer num : numListB) {
            setPrimeCountMap(primeCountOfB, num);
        }

        // Intersection key of prime
        Set<Integer> primeOfA = primeCountOfA.keySet();
        Set<Integer> primeOfB = primeCountOfB.keySet();
        primeOfA.retainAll(primeOfB); // now primeOfA is intersection set

        // get GCD
        long GCD = 1;
        for (Integer num : primeOfA) {
            int minCount = getMinVal(num);
            for (int i = 0; i < minCount; i++) {
                GCD = GCD * num;
            }
        }

        // print GCD
        String result = String.valueOf(GCD);
        if (result.length() > 9) {
            result = result.substring(result.length() - 9);
        }
        System.out.println(result);

        br.close();
    }

    private static int getMinVal(Integer num) {
        int valueOfA = primeCountOfA.getOrDefault(num, 0);
        int valueOfB = primeCountOfB.getOrDefault(num, 0);

        return Math.min(valueOfA, valueOfB);
    }

    private static void setPrimeCountMap(Map<Integer, Integer> pf, Integer target) {
        for (int i = 2; i <= Math.sqrt(target); i++) {
            while (target % i == 0) {
                pf.put(i, pf.getOrDefault(i, 0) + 1); // (value count of dictionary)++
                target = target / i;
            }
        }
        pf.put(target, pf.getOrDefault(target, 0) + 1); // target is 1 or prime number
    }
}
