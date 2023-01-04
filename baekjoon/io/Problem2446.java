package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2446 {

    /*
     * https://www.acmicpc.net/problem/2446
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        /*
        * 0 9(2*5 - 1)
        * 1 7(2*4 - 1)
        * 2 5(2*3 - 1)
        * 3 3(2*2 - 1)
        * 4 1(2*1 - 1)
        * 3 3(2*2 - 1)
        * 2 5(2*3 - 1)
        * 1 7(2*4 - 1)
        * 0 9(2*5 - 1)
        * */

        int i = 0;
        int weight = 1;
        while(i >= 0){
            if(i == num - 1){
                weight = -1;
            }

            for (int j = 0; j < i; j++) {
                sb.append(' ');
            }
            for (int j = 0; j < 2 * (num - i) - 1; j++) {
                sb.append('*');
            }
            sb.append('\n');

            i += weight;
        }

        System.out.print(sb);

        br.close();
    }
}
