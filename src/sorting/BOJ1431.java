package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1431 {

    public static void main(String[] args) throws IOException {
        /* Read input N */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* Create Serial List */
        List<Serial> serialList = new ArrayList<>();
        while (N-- > 0) {
            serialList.add(new Serial(br.readLine()));
        }

        /* Sort List */
        serialList.sort((s1, s2) -> {
            if (s1.getLength() != s2.getLength()) { // case 1
                return s1.getLength() - s2.getLength();
            } else if (s1.getNumSum() != s2.getNumSum()) { // case 2
                return s1.getNumSum() - s2.getNumSum();
            } else { // case 3
                return s1.getSerial().compareTo(s2.getSerial());
            }
        });

        /* Print result */
        StringBuilder sb = new StringBuilder();
        for (Serial s : serialList) {
            sb.append(s.getSerial()).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}

class Serial {

    private final String serial;
    private final int length;
    private int numSum = 0;

    public Serial(String serial) {
        this.serial = serial;
        this.length = serial.length();

        /* Init numSum */
        for (char c : serial.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numSum += c - '0';
            }
        }
    }

    public String getSerial() {
        return serial;
    }

    public int getLength() {
        return length;
    }

    public int getNumSum() {
        return numSum;
    }
}
