package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int length = str.length();
        int number = Integer.parseInt(str);

        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            int pow = (int) Math.pow(10, i);
            int digit = number / pow;
            number = number - (digit * pow);

            sb.append('[');
            sb.append(digit).append(Integer.toString(pow).substring(1));
            sb.append(']').append('\n');
        }

        System.out.println(sb);
        br.close();

    }
}

