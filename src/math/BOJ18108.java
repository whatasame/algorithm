package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18108 {

    public static void main(String[] args) throws IOException {
        /* Read input Y */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int Y = Integer.parseInt(br.readLine());

        /* Compute result */
        int result = Y - 543;

        /* Print result */
        System.out.println(result);

        br.close();
    }

}
