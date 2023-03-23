package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3053 {

    public static void main(String[] args) throws IOException {
        /* Read input R */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int R = Integer.parseInt(br.readLine());

        /* Compute euclidean area */
        double euclideanArea = R * R * Math.PI;

        /* Compute taxi geometry area */
        double taxiArea = 2 * R * R;

        /* Print result */
        System.out.printf("%.6f\n", euclideanArea);
        System.out.printf("%.6f\n", taxiArea);

        br.close();
    }

}
