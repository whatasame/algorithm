package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15685 {

    private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;
    private static final int ARRAY_LENGTH = 101;

    private static final boolean[][] arr = new boolean[ARRAY_LENGTH][ARRAY_LENGTH];

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        /* Draw dragon cover */
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            draw(startX, startY, getDirections(dir, gen));
        }

        /* Print result */
        int result = getCountOfRectangle();
        System.out.println(result);

        br.close();
    }


    public static List<Integer> getDirections(int firstDir, int generation) {
        List<Integer> directions = new ArrayList<>();
        directions.add(firstDir);

        /* Generate dragon cover direction list */
        while (generation-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int newDir = (directions.get(i) + 1) % 4;
                directions.add(newDir);
            }
        }

        return directions;
    }

    public static void draw(int x, int y, List<Integer> directions) {
        /* Init start point */
        arr[x][y] = true;

        /* Draw point of dragon cover */
        for (int dir : directions) {
            switch (dir) {
                case RIGHT:
                    arr[++x][y] = true;
                    break;
                case UP:
                    arr[x][--y] = true;
                    break;
                case LEFT:
                    arr[--x][y] = true;
                    break;
                case DOWN:
                    arr[x][++y] = true;
                    break;
            }
        }
    }


    public static int getCountOfRectangle() {
        int count = 0;

        for (int x = 0; x < ARRAY_LENGTH - 1; x++) {
            for (int y = 0; y < ARRAY_LENGTH - 1; y++) {
                if (arr[x][y] && arr[x + 1][y] && arr[x][y + 1] && arr[x + 1][y + 1])
                    count++;
            }
        }

        return count;
    }

}
