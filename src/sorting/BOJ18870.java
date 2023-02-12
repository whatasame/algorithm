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

        /* Create List */
        StringTokenizer st = new StringTokenizer(numStr, " ");
        List<Integer> numList = new ArrayList<>();
        while (N-- > 0) {
            numList.add(Integer.parseInt(st.nextToken()));
        }
        numList.sort(Comparator.naturalOrder());

        /* Generate Map */
        Map<Integer, Integer> countMap = new HashMap<>();
        int idx = 0;
        for (int num : numList) {
            if (countMap.get(num) == null) {
                countMap.put(num, idx++);
            }
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
