package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11721 {

    /*
     * https://www.acmicpc.net/problem/11721
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String inputString = br.readLine();

        for (int i = 0; i < inputString.length(); i++) {
            if (i != 0 && i % 10 == 0) {
                sb.append('\n');
            }
            sb.append(inputString.charAt(i));
        }

        System.out.println(sb);

        br.close();
    }
}
