package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10814 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Create Heap */
        Queue<Member> heap = new PriorityQueue<>((m1, m2) -> {
            if (m1.getAge() != m2.getAge()) {
                return m1.getAge() - m2.getAge(); // ascending -> minHeap
            } else {
                return 0;
            }
        });

        /* Add heap data */
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            heap.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        /* Print result */
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            sb.append(heap.poll().toString()).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

}

class Member {

    private final int age;
    private final String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d %s", age, name);
    }
}
