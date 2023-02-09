package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ".");
        int yyyy = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        int dd = Integer.parseInt(st.nextToken());

        System.out.printf("%04d.%02d.%02d", yyyy, mm, dd);
    }
}
