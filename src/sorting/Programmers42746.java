package sorting;

import java.util.Arrays;
import java.util.Comparator;

class Programmers42746 {

    public String run(int[] numbers) {

        // Generate string array
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf((numbers[i]));
        }

        // Sort
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // Exception handling {0, 0, ... , 0} != "00000", == "0"
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Create result string
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }

        return sb.toString();
    }

}

class Solution {
    public String solution(int[] numbers) {

        Programmers42746 p = new Programmers42746();

        return p.run(numbers);
    }
}