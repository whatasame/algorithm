package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {

    public static void main(String[] args) throws IOException {
        /* Read Test Case number */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* Compute position */
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            /* Read N, M, Priority */
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            /* Generate queue */
            st = new StringTokenizer(br.readLine(), " ");
            Queue<Document> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                queue.offer(new Document(i, Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            while (true) {
                Document front = queue.remove();
                boolean isMax = true; // If front's priority is greatest, front will be dequeued

                for (Document doc : queue) {
                    if (doc.getPriority() > front.getPriority()) {
                        isMax = false; // not greatest
                        queue.add(front); // insert at the rear of the queue
                        break;
                    }
                }

                if (isMax) {
                    count++; // dequeue
                    if (front.getIndex() == M) { // When front is target
                        break;
                    }
                }

            }
            sb.append(count).append('\n');
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }
}

class Document {

    private final int index;
    private final int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }
}

