package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Init ropeWeightList by input ROPE */
        int[] ropeWeightList = new int[N];
        for (int i = 0; i < N; i++) {
            ropeWeightList[i] = Integer.parseInt(br.readLine());
        }

        /* Sort ropeWeightList ascending */
        Arrays.sort(ropeWeightList);

        /* Compute maxWeight */
        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            maxWeight = Math.max(maxWeight, ropeWeightList[i] * (N - i));
        }

        /* Print maxWeight */
        System.out.println(maxWeight);

        br.close();
    }
}
