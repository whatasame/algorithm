package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1304 {

    private static List<List<Integer>> graph;

    private static boolean[] visited;
    private static boolean[] finished;

    private static final List<Cycle> cycleList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        /* Read input N, M */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        /* Init directed graph */
        graph = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        /* Add expressway */
        for (int i = 1; i < N; i++) {
            graph.get(i).add(i + 1);
        }

        /* Add general road */
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        /* Prepare DFS */
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        for (List<Integer> neighbor : graph) {
            Collections.sort(neighbor);
        }

        /* Find cycle */
        for (int i = 1; i <= N; i++) {
            checkCycle(i); // dfs
        }

        /* Compute min offset of area*/
        int offset;
        a:
        for (offset = 0; offset <= N; offset++) {
            int start;
            int end = 0;

            while (true) {
                if (end >= N) {
                    break a;
                }
                start = end + 1;
                end = start + offset;

                if (!isValidArea(end)) {
                    break;
                }
            }
        }



        /* Print result */
        int length = offset + 1;
        System.out.println(N / length);

        br.close();
    }

    private static boolean isValidArea(int end) {
        for (Cycle cycle : cycleList) {
            if (end < cycle.from && end >= cycle.to) {
                return false;
            }
        }
        return true;
    }

    private static void checkCycle(int v) {
        visited[v] = true;

        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                checkCycle(neighbor);
            } else if (!finished[neighbor]) {
                cycleList.add(new Cycle(v, neighbor));
            }
        }

        finished[v] = true;
    }

    static class Cycle {
        int from;

        int to;

        public Cycle(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

}
