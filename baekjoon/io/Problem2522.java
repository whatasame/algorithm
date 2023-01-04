package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2522 {

    /*
     * https://www.acmicpc.net/problem/2522
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int i = 1;
        int weight = 1;
        while(i > 0){
            if(i == num){
                weight = -1;
            }

            for (int j = 0; j < num - i; j++) {
                sb.append(' ');
            }
            for (int j = 0; j < i; j++) {
                sb.append('*');
            }
            sb.append('\n');

            i += weight;
        }

        System.out.print(sb);

        br.close();
    }
}
