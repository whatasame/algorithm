package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11718 {

    /*
    * https://www.acmicpc.net/problem/11718
    * */

    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            line = br.readLine();

            if (line == null || line.isEmpty()) {
                break;
            }

            sb.append(line).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}