package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1011 {

    public static void main(String[] args) throws IOException {
        /* Read input T */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* Loop T */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            /* Compute move count */
            int moveCount = getMoveCount(x, y);
            sb.append(moveCount).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

    private static int getMoveCount(int x, int y) {

        int amount = 0;
        while (x < y) {
            amount++;
            x += amount;
            y -= amount;
        }

        return x - y >= amount ? 2 * amount - 1 : 2 * amount;
    }

}