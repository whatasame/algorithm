package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1027 {

    /*
    * https://codeup.kr/problem.php?id=1027
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ".");

        String yyyy = st.nextToken();
        String mm = st.nextToken();
        String dd = st.nextToken();

        System.out.printf("%s-%s-%s", dd, mm, yyyy);

        br.close();
    }
}
