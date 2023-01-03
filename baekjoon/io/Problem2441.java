package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2441 {

    /*
    * https://www.acmicpc.net/problem/2441
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(' ');
            }
            for (int j = 0; j < num - i; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.print(sb);

        br.close();
    }
}
