package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1023 {

    /*
    * https://codeup.kr/problem.php?id=1023
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ".");
        StringBuilder sb = new StringBuilder();

        sb.append(st.nextToken()).append('\n').append(st.nextToken());

        System.out.println(sb);

        br.close();
    }
}
