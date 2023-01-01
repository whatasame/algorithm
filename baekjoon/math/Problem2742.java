package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2742 {

    /*
    * https://www.acmicpc.net/problem/2742
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = num; i > 0; i--) {
            System.out.println(i);
        }

        br.close();
    }
}
