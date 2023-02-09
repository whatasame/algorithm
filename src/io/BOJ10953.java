package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10953 {

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        int num1, num2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcaseCount; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());

            System.out.println(num1 + num2);
        }

        br.close();
    }
}
