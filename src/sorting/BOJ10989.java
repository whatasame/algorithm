package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10989 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init radix array */
        int[] arr = new int[10001]; // arr[i] == count of 'i'
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        /* Count number */
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        /* Print number */
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            while (arr[i]-- > 0) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);

        br.close();
    }
}
