package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17087 {

    /*
     * https://www.acmicpc.net/problem/17087
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Read data N, S
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // Read FIRST data position of brother and compute distance
        st = new StringTokenizer(br.readLine(), " ");
        int position = Integer.parseInt(st.nextToken()); // position of brother
        int distance = getDistance(position, S);
        N--;

        // Compute GCD with remain data of brother
        int GCD = distance;
        while (N-- > 0) {
            position = Integer.parseInt(st.nextToken()); // position of brother
            distance = getDistance(position, S);
            GCD = getGCD(GCD, distance);
        }

        // Print result
        System.out.println(GCD);

        br.close();
    }

    private static int getGCD(int a, int b) {
        int r;

        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }


    private static int getDistance(int position, int s) {
        int distance = position - s;

        return distance > 0 ? distance : -distance;
    }
}
