package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10870 {

    public static void main(String[] args) throws IOException {
        /* Read Input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Compute Nth Fibonacci number */
        int result = fibo(N);

        /* Print result */
        System.out.println(result);

        br.close();
    }

    private static int fibo(int N) {
        if (N < 2) {
            return N;
        }
        return fibo(N - 1) + fibo(N - 2);
    }
}
