package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8393 {

    /*
    * https://www.acmicpc.net/problem/8393
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i < num + 1; i++) {
            sum += i;
        }

        System.out.println(sum);

        br.close();
    }
}
