package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ1715 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        /* Init minHeap */
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            minHeap.offer(Integer.parseInt(br.readLine()));
        }

        /* Compute compare count */
        int compareCount = 0;
        while (minHeap.size() > 1) {
            int sum = minHeap.poll() + minHeap.poll();
            minHeap.offer(sum);

            compareCount += sum;
        }

        /* Print compareCount */
        System.out.println(compareCount);

        br.close();
    }

}
