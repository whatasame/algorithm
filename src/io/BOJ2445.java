package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2445 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int i = 1;
        int weight = 1; // ascending
        while (i > 0) {
            if (i == num) {
                weight = -1; // descending
            }

            for (int j = 0; j < i; j++) {
                sb.append('*');
            }
            for (int j = 0; j < 2 * (num - i); j++) {
                sb.append(' ');
            }
            for (int j = 0; j < i; j++) {
                sb.append('*');
            }
            sb.append('\n');

            i += weight;
        }

        System.out.print(sb);

        br.close();
    }
}
