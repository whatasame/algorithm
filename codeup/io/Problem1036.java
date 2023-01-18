package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1036 {

    /*
     * https://codeup.kr/problem.php?id=1034
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = br.readLine().charAt(0);

        System.out.println(n);

        br.close();
    }
}
