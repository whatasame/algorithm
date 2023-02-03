package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem1935 {

    /*
     * https://www.acmicpc.net/problem/1935
     * */

    public static void main(String[] args) throws IOException {
        /* Read Input N, str */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        /* Mapping alphabet and number */
        Map<Character, Integer> map = new HashMap<>();
        char key = 'A';
        while (N-- > 0) {
            map.put(key++, Integer.parseInt(br.readLine()));
        }

        /* Compute expression */
        Stack<Double> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '*') {
                Double o1 = stack.pop();
                Double o2 = stack.pop();
                stack.push(o2 * o1);
            } else if (c == '/') {
                Double o1 = stack.pop();
                Double o2 = stack.pop();
                stack.push(o2 / o1);
            } else if (c == '+') {
                Double o1 = stack.pop();
                Double o2 = stack.pop();
                stack.push(o2 + o1);
            } else if (c == '-') {
                Double o1 = stack.pop();
                Double o2 = stack.pop();
                stack.push(o2 - o1);
            } else {
                stack.push(Double.valueOf(map.get(c)));
            }
        }

        /* Print result */
        System.out.printf("%.2f", stack.pop());

        br.close();
    }
}
