package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2252 {

    private static int N;

    public static void main(String[] args) throws IOException {
        /* Read input N, M */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /* Init graph */
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) { // vertices start with 1 (1 ~ N)
            graph.add(new LinkedList<>());
        }

        /* Read input order: edge<A, B> */
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B); // Add edge<A, B>
        }

        /* Topological sort */
        List<Integer> orderList = sort(graph);

        /* Print result */
        StringBuilder sb = new StringBuilder();
        for (int vertex : orderList) {
            sb.append(vertex).append(' ');
        }
        System.out.println(sb);

        br.close();
    }

    private static List<Integer> sort(List<List<Integer>> graph) {
        /* Create return array */
        List<Integer> orderList = new LinkedList<>();

        /* Compute in-degree */
        int[] inDegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int neighbor : graph.get(i)) {
                inDegree[neighbor]++;
            }
        }

        /* Enqueue vertices which has 0 in-degree  */
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        /* Topological sort */
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            orderList.add(vertex);

            for (int neighbor : graph.get(vertex)) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return orderList;
    }
}
