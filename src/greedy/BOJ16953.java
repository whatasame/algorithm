package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953 {

    private static int A, B;
    private static int count;
    private static boolean isOver = true;

    public static void main(String[] args) throws IOException {
        /* Read input A, B */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        /* Compute count of operation */
        dfs(A, 0);

        /* Print result */
        System.out.println(isOver ? -1 : count + 1);
    }

    public static void dfs(long num, int cnt) {
        if (num > B) {
            return;
        } else if (num == B) {
            isOver = false;
            count = cnt;
            return;
        }

        dfs(num * 2, cnt + 1);
        dfs(num * 10 + 1, cnt + 1);
    }

}
