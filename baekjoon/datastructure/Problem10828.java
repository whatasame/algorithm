package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10828 {

    /*
    * https://www.acmicpc.net/problem/10828
    * */

    public static void main(String[] args) throws IOException {
        // Read N data input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Create Integer type stack
        Stack stack = new Stack();

        // Compute instruction
        StringBuilder sb = new StringBuilder();
        String inst;
        String result;
        for (int i = 0; i < N; i++) {
            inst = br.readLine();
            result = stack.manager(inst);
            if (!result.equals("")) {
                sb.append(result).append('\n');
            }
        }

        // Print result
        System.out.println(sb);
        br.close();
    }


}

class Stack {

    public int[] data = new int[10000]; // data of stack
    public int tos = -1; // top of stack

    public String manager(String inst) {
        // Split instruction by ' '
        StringTokenizer st = new StringTokenizer(inst, " ");
        String operator = st.nextToken();

        // Distinguish inst
        switch (operator) {
            case "push":
                int operand = Integer.parseInt(st.nextToken());
                push(operand);
                return "";
            case "pop":
                return String.valueOf(pop());
            case "size":
                return String.valueOf(size());
            case "empty":
                return String.valueOf(empty());
            case "top":
                return String.valueOf(top());
            default:
                throw new RuntimeException("Unsupported instruction");
        }
    }

    private int top() {
        return tos == -1 ? -1 : data[tos];
    }

    private int empty() {
        return tos == -1 ? 1 : 0;
    }

    private int size() {
        return tos + 1;
    }

    private int pop() {
        // Check stack is empty
        if(size() == 0){
            return -1;
        }

        return data[tos--];
    }

    private void push(int operand) {
        this.data[++tos] = operand;
    }

}
