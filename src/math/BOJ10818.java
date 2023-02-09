package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10818 {

    /*
     * https://www.acmicpc.net/problem/10818
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int maxNum = num;
        int minNum = num;
        for (int i = 1; i < numCount; i++) {
            num = Integer.parseInt(st.nextToken());

            if (num > maxNum) {
                maxNum = num;
            } else if (num < minNum) {
                minNum = num;
            }
        }

        System.out.println(minNum + " " + maxNum);

        br.close();
    }
}
