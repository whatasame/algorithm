package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem5430 {

    /*
     * https://www.acmicpc.net/problem/5430
     * */

    private static boolean reverse;
    private static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        /* Read input T */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            /* Init flag */
            reverse = false;

            /* Read p, n, arr */
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            deque = getDeque(n, br.readLine());

            /* Compute function p */
            String result = parseFunc(p);
            sb.append(result).append('\n');
        }

        /* Print result */
        System.out.println(sb);
        br.close();
    }

    private static String parseFunc(String p) {
        for (int i = 0; i < p.length(); i++) {
            char func = p.charAt(i);

            if (func == 'R') {
                reverse = !reverse;
            } else if (func == 'D') {
                if (pop() == null) {
                    return "error";
                }
            }
        }

        int size = deque.size();
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(pop());
            if (i < size - 1) {
                sb.append(',');
            }
        }
        sb.append(']');

        return sb.toString();
    }

    private static Integer pop() {
        return reverse ? deque.pollLast() : deque.pollFirst();
    }

    private static Deque<Integer> getDeque(int size, String readLine) {
        String content = readLine.substring(1, readLine.length() - 1); // [13,2,73,674] -> 13,2,73,674
        StringTokenizer st = new StringTokenizer(content, ",");

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            deque.add(Integer.valueOf(st.nextToken()));
        }

        return deque;
    }
}
