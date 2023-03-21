package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1011 {

    private static boolean found;
    private static int result;

    public static void main(String[] args) throws IOException {
        /* Read input T */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* Loop T */
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            found = false;
            if (y - x == 1) {
                System.out.println(1);
            } else {
                getResult(x + 1, y - 1, 1, 1);
                System.out.println(result + 1);
            }


        }

        br.close();
    }

    private static void getResult(int now, int end, int moved, int count) {
        if (found || moved <= 0 || now > end) {
            return;
        }

        if (now == end) {
            found = true;
            result = count;
            return;
        } else {
            getResult(now + moved + 1, end, moved + 1, count + 1);
            getResult(now + moved, end, moved, count + 1);
            getResult(now + moved - 1, end, moved - 1, count + 1);
        }


    }

}
