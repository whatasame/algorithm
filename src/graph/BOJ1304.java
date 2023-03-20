package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1304 {

    private static int N;
    private static List<List<Integer>> graph;

    private static boolean[] visited, finished;

    private static final List<Cycle> cycleList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        /* Read input N, M */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        /* Init directed graph */
        graph = new LinkedList<>();
        for (int i = 0; i <= N; i++) { // Init vertex
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) { //  Add expressway
            graph.get(i).add(i + 1);
        }
        for (int i = 0; i < M; i++) { //  Add general road
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

        /* Compute min area size */
        int size = getMinAreaSize();

        /* Print result */
        System.out.println(N / size);

        br.close();
    }

    private static int getMinAreaSize() {
        for (int offset = 0; offset <= N; offset++) {
            /* Area: start ~ end */
            int start, end = 0;

            while (end <= N) { // Area is out of range
                if (end == N) { // Find min size
                    return offset + 1;
                }

                /* Compute area */
                start = end + 1;
                end = start + offset;

                /* Check cycle's arrival point exists in area */
                if (!hasCycleArrivalPoint(end)) {
                    break;
                }
            }
        }

        return 0; // unreachable statement
    }

    private static boolean hasCycleArrivalPoint(int end) {
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
            } else if (!finished[neighbor]) { // Cycle exists
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
