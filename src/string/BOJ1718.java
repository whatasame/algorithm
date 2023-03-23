package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1718 {

    public static void main(String[] args) throws IOException {
        /* Read input PLAIN, KEY */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] PLAIN = br.readLine().toCharArray();
        final char[] KEY = br.readLine().toCharArray();

        /* Generate cypher */
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char p : PLAIN) {
            if (p == ' ') {
                sb.append(' ');
            } else {
                /* Compute encrypted character */
                int interval = KEY[idx] - 'a' + 1;

                int encrypted = p - interval;
                encrypted = encrypted < 'a' ? ('z' + 1) - ('a' - encrypted) : encrypted;

                sb.append((char) encrypted);
            }

            idx = (idx + 1) % KEY.length;
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

}
