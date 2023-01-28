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
        while (T-- > 0) {

            /* Read p, n, arr */
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            deque = getDeque(n, br.readLine());

            /* Parse function p */
            String result = parseFunc(p);
            sb.append(result).append('\n');
        }

        /* Print result */
        System.out.println(sb);
        br.close();
    }

    private static String parseFunc(String p) {
        /* Init flag */
        reverse = false;

        /* Parse string p */
        for (char func : p.toCharArray()) {
            if (func == 'R') {
                reverse = !reverse;
            } else if (func == 'D') {
                if (poll() == null) {
                    return "error";
                }
            }
        }

        /* Generate array string */
        if(deque.isEmpty()){
            return "[]";
        }
        int idxMax = deque.size() - 1;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(poll());
            if (i == idxMax) {
                return sb.append(']').toString();
            }
            sb.append(',');
        }
    }

    private static Integer poll() {
        return reverse ? deque.pollLast() : deque.pollFirst();
    }

    private static Deque<Integer> getDeque(int n, String readLine) {
        StringTokenizer st = new StringTokenizer(readLine, "[],");

        Deque<Integer> deque = new LinkedList<>();
        while (n-- > 0) {
            deque.offer(Integer.valueOf(st.nextToken()));
        }

        return deque;
    }
}
