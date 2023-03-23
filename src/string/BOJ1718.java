package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1718 {

    private static final int MAX_ALPHABET_NUM = 26;

    public static void main(String[] args) throws IOException {
        /* Read input PLAIN, KEY */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String PLAIN = br.readLine();
        final String KEY = br.readLine();

        /* Run algorithm */
        String cypher = encrypt(PLAIN, KEY);

        /* Print result */
        System.out.println(cypher);

        br.close();
    }

    private static String encrypt(String plain, String key) {
        StringBuilder cypher = new StringBuilder();

        for (int i = 0; i < plain.length(); i++) {
            char p = plain.charAt(i);
            char k = key.charAt(i % key.length());

            if (p == ' ') {
                cypher.append(p);
            } else {
                /* Alphabet number starts with 1 */
                int plainNum = p - 'a' + 1;
                int keyNum = k - 'a' + 1;

                int encrypted = plainNum - keyNum;
                if (encrypted <= 0) {
                    encrypted = MAX_ALPHABET_NUM + encrypted;
                }

                encrypted--; // because 'a' starts with 0, not starts with 1

                cypher.append((char) ('a' + encrypted)); // 'a' = 'a' + 0, not 'a' + 1
            }
        }

        return cypher.toString();
    }


}
