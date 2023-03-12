package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11000 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        /* Init startMinHeap */
        Queue<Lecture> startMinHeap = new PriorityQueue<>((l1, l2) -> {
            return l1.start - l2.start;
        });
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            startMinHeap.offer(new Lecture(start, end));
        }

        /* Compute lecture schedule */
        Queue<Lecture> endMinHeap = new PriorityQueue<>((l1, l2) -> {
            return l1.end - l2.end;
        });
        endMinHeap.offer(startMinHeap.poll());
        while (!startMinHeap.isEmpty()) {
            Lecture lastLecture = endMinHeap.peek();
            Lecture nextLecture = startMinHeap.peek();

            if (lastLecture.end > nextLecture.start) {
                endMinHeap.offer(startMinHeap.poll());
            } else {
                endMinHeap.poll();
                endMinHeap.offer(startMinHeap.poll());
            }
        }

        /* Print result */
        System.out.println(endMinHeap.size());


        br.close();
    }

    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
