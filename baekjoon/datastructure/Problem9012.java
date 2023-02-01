package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem9012 {

    /*
     * https://www.acmicpc.net/problem/9012
     * */

    public static void main(String[] args) throws IOException {
        /* Ready Input T */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* Check VPS */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String result = VPS(br.readLine());
            sb.append(result).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    private static String VPS(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if (c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.empty() ? "YES" : "NO";
    }
}
