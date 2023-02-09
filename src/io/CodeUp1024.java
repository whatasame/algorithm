package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : charArr) {
            sb.append('\'').append(c).append('\'').append('\n');
        }

        System.out.println(sb);

        br.close();

    }
}
