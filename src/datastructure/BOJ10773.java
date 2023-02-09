package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {

    public static void main(String[] args) throws IOException {
        /* Read input K */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        /* Generate stack */
        Stack<Integer> stack = new Stack<>();
        while (K-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        /* Print result */
        int sum = 0;
        for (Integer n : stack) {
            sum += n;
        }
        System.out.println(sum);

        br.close();
    }
}
