package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2812 {

    public static void main(String[] args) throws IOException {
        /* Read input N, K, number string */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String numStr = br.readLine();

        /* Delete K numbers */
        Stack<Integer> stack = new Stack<>();
        int count = 0; // pop count
        for (int i = 0; i < N; i++) {
            int num = Character.getNumericValue(numStr.charAt(i));

            while (!stack.isEmpty() && stack.peek() < num && count < K) {
                stack.pop();
                count++;
            }
            stack.push(num);

        }
        while (count++ < K) {
            stack.pop();
        }

        /* Print stack data */
        StringBuilder sb = new StringBuilder();
        for (Integer n : stack) {
            sb.append(n);
        }
        System.out.println(sb);

        br.close();
    }
}
