package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18870 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numStr = br.readLine();

        /* Creat set */
        Set<Integer> numSet = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(numStr, " ");
        while (N-- > 0) {
            numSet.add(Integer.parseInt(st.nextToken()));
        }

        /* Set to List */
        List<Integer> numList = new ArrayList<>(numSet);

        /* Generate Map */
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < numList.size(); i++) {
            countMap.put(numList.get(i), i);
        }

        /* Print result */
        st = new StringTokenizer(numStr, " ");
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(countMap.get(Integer.parseInt(st.nextToken()))).append(' ');
        }
        System.out.println(sb);

        br.close();
    }
}
