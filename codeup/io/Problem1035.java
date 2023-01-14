package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1035 {

    /*
     * https://codeup.kr/problem.php?id=1034
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine(), 16);

        System.out.println(Integer.toOctalString(num));

        br.close();
    }
}
