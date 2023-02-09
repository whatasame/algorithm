package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2438 {

    /*
     * https://www.acmicpc.net/problem/2438
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}
