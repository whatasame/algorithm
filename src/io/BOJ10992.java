package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10992 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num - i; j++) {
                sb.append(' ');
            }

            if (i == 1) {
                sb.append('*');
            } else if (i == num) {
                for (int j = 0; j < 2 * num - 1; j++) {
                    sb.append('*');
                }
            } else {
                sb.append('*');
                for (int j = 0; j < 2 * (i - 1) - 1; j++) {
                    sb.append(' ');
                }

                sb.append('*');
            }

            sb.append('\n');
        }

        System.out.print(sb);

        br.close();
    }
}
