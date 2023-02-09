package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10845 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue queue = new Queue();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String operator = st.nextToken();
            switch (operator) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.empty()).append('\n');
                    break;
                case "front":
                    sb.append(queue.front()).append('\n');
                    break;
                case "back":
                    sb.append(queue.back()).append('\n');
                    break;
            }
        }

        /* Print result */
        System.out.println(sb);

        br.close();
    }

}

class Queue {

    private final int[] value = new int[10000];

    private int front = 0; // dequeue position
    private int rear = 0; // enqueue position

    private int size = 0;

    public void push(int num) {
        value[rear++] = num;
        size++;
    }

    public int pop() {
        if (empty() == 1) {
            return -1;
        }

        size--;
        return value[front++];
    }

    public int size() {
        return this.size;
    }

    public int empty() {
        return size() == 0 ? 1 : 0;
    }

    public int front() {
        if (empty() == 1) {
            return -1;
        }

        return value[front];
    }

    public int back() {
        if (empty() == 1) {
            return -1;
        }

        return value[rear - 1];
    }


}
