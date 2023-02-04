package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem2493 {

    /*
     * https://www.acmicpc.net/problem/2493
     * */

    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> popDataQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Compute receive tower index */
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            int height = Integer.parseInt(st.nextToken());
            int result = getIndex(height);
            sb.append(result).append(' ');
        }

        /* Print result */
        System.out.println(sb.toString().trim());

        br.close();
    }

    private static int getIndex(int height) {
        int count = 0; // count of pop()
        boolean received = false;
        while (!stack.empty()) {
            int tos = stack.pop();
            popDataQueue.offer(tos);
            count++;

            if (tos >= height) {
                received = true;
                break;
            }
        }

        /* Recovery stack data */
        while (!popDataQueue.isEmpty()) {
            stack.push(popDataQueue.poll());
        }

        /* Push new data to stack */
        stack.push(height);

        return received ? stack.size() - count : 0;
    }
}
