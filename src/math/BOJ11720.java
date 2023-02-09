package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {

    /*
     * https://www.acmicpc.net/problem/11720
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCount = Integer.parseInt(br.readLine());

        int sum = 0;
        String numString = br.readLine();
        for (int i = 0; i < numCount; i++) {
            sum += Character.getNumericValue(numString.charAt(i));
        }

        System.out.println(sum);

        br.close();
    }
}
