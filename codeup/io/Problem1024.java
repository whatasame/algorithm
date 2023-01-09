package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1024 {

    /*
     * https://codeup.kr/problem.php?id=1024
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for(char c : charArr){
            sb.append('\'').append(c).append('\'').append('\n');
        }

        System.out.println(sb);

        br.close();

    }
}
