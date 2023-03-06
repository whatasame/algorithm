package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14916 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Run algorithm */
        int coinCount = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                /* change all to 5KRW at once */
                int fiveCoinCount = N / 5;
                N -= 5 * fiveCoinCount;

                coinCount += fiveCoinCount;
            } else {
                /* change to 2KRW once */
                N -= 2;
                coinCount++;
            }
        }

        if (N == 0) { // Change success
            System.out.println(coinCount);
        } else { // Change failed
            System.out.println(-1);
        }

        br.close();
    }
}
