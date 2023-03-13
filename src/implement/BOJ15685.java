package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ15685 {

    private static final int ARRAY_LENGTH = 100;

    private static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        /* Init arr */
        arr = new boolean[ARRAY_LENGTH][ARRAY_LENGTH];

        /* Draw dragon cover */
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());

            draw(startX, startY, direction, generation);
        }

        /* Count rectangle */
        int count = 0;
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            for (int j = 0; j < ARRAY_LENGTH; j++) {
                if (arr[i][j]
                        && isValidIndex(i + 1, j + 1) // Check valid index
                        && arr[i + 1][j] && arr[i][j + 1] && arr[i + 1][j + 1]) { // Check rectangle
                    count++;
                }

            }
        }

        /* Print result */
        System.out.println(count);

        br.close();
    }

    public static void draw(int startX, int startY, int direction, int generation) {
        Stack<Integer> directionStack = new Stack<>();
        directionStack.push(direction);

        for (int i = 0; i < generation; i++) {
            /* Copy directionStack */
            Stack<Integer> tmp = new Stack<>();
            for (Integer dir : directionStack) {
                tmp.push(dir);
            }

            /* Generate dragon cover */
            while (!directionStack.empty()) {
                tmp.push((directionStack.pop() + 1) % 4);
            }
            directionStack = tmp;
        }

        /* Init start point */
        int x = startX;
        int y = startY;
        arr[y][x] = true;

        /* Draw dragon cover */
        for (int dir : directionStack) {
            switch (dir) { // Compute position
                case 0:
                    x++;
                    break;
                case 1:
                    y--;
                    break;
                case 2:
                    x--;
                    break;
                case 3:
                    y++;
                    break;
            }
            if (isValidIndex(y, x)) {
                arr[y][x] = true; // draw
            }
        }
    }

    public static boolean isValidIndex(int i, int j) {
        return i < ARRAY_LENGTH && j < ARRAY_LENGTH;
    }
}
