package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2739 {

    /*
     * https://www.acmicpc.net/problem/2739
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; i++) {
            sb.append(num).append(" * ").append(i).append(" = ").append(num * i).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
