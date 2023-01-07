package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1020 {

    /*
    * https://codeup.kr/problem.php?id=1020
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, "-");

        sb.append(st.nextToken()).append(st.nextToken());

        System.out.println(sb);

        br.close();
    }

}
