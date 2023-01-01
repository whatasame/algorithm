package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1924 {

    /*
     * https://www.acmicpc.net/problem/1924
     * */

    private static final Map<Integer, Integer> maxDay = new HashMap<Integer, Integer>(){
        {
            put(1, 31);
            put(2, 28);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int mon = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int daySum = 0;
        for(int i = 1; i < mon; i++){
            daySum += maxDay.get(i);
        }
        daySum += day;

        String[] dayKind = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        System.out.println(dayKind[daySum % 7]);

        br.close();

    }
}
