package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11021 {

    /*
     * https://www.acmicpc.net/problem/11021
     * */

    public static void main(String[] args) throws IOException {

        int num1, num2;
        StringTokenizer st;
        StringBuilder sb;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcaseCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb = new StringBuilder();

            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i + 1).append(": ").append(num1 + num2);
            System.out.println(sb);
        }

        br.close();
    }
}
