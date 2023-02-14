package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Run algorithm */
        int count = getCount(N);

        /* Print result */
        System.out.println(count);

        br.close();
    }

    private static int getCount(int num) {
        int count = 0;
        while (num != 1) {
            if (num % 3 == 0) {
                num /= 3;
            } else if ((num - 1) % 3 == 0) {
                num--;
                count++;
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else if ((num - 1) % 2 == 0) {
                num--;
                count++;
                num /= 2;
            }
            count++;
        }
        return count;
    }

}