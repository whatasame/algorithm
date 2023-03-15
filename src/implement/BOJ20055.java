package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055 {

    private static int N;

    private static int K;
    private static boolean[] robot;
    private static int[] durability;


    public static void main(String[] args) throws IOException {
        /* Read input N, K */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        /* Init robot, durability */
        robot = new boolean[N];
        durability = new int[2 * N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        /* Compute count of step */
        int result = solution();

        /* Print result */
        System.out.println(result);

        br.close();
    }

    public static int solution() {
        int stepCount = 0;
        while (true) {
            /* process start */
            stepCount++;

            /* process 1 */
            for (int i = robot.length - 1; i > 0; i--) { // move robot
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            int bak = durability[2 * N - 1]; // move belt
            for (int i = durability.length - 1; i > 0; i--) {
                durability[i] = durability[i - 1];
            }
            durability[0] = bak;

            /* process 2 */
            robot[N - 1] = false;
            for (int i = N - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && durability[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    durability[i + 1]--;
                }
            }

            /* process 3 */
            if (durability[0] > 0) {
                robot[0] = true;
                durability[0]--;
            }

            /* process 4 */
            if (isStop()) {
                break;
            }
        }

        return stepCount;
    }

    public static boolean isStop() {
        int count = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (durability[i] == 0) {
                count++;
            }
        }

        return count >= K;
    }
}
