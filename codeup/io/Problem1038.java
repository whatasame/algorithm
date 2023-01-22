package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1038 {

    /*
     * https://www.codeup.kr/problem.php?id=1038
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        System.out.println(num1 + num2);

        br.close();

    }
}
