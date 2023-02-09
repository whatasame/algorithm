package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class CodeUp1029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DecimalFormat df = new DecimalFormat("#.00000000000");

        double num = Double.parseDouble(br.readLine());

        System.out.println(df.format(num));

        br.close();
    }
}
