package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1343 {

    public static void main(String[] args) throws IOException {
        /* Read input boardStr */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String boardStr = br.readLine();

        /* Replace boardStr's "XXXX" to "AAAA" */
        boardStr = boardStr.replaceAll("XXXX", "AAAA");

        /* Replace boardStr's "XX" to "BB" */
        boardStr = boardStr.replaceAll("XX", "BB");

        /* Print result */
        if (boardStr.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(boardStr);
        }

        br.close();
    }
}