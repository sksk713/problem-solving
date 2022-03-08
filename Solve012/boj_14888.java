package Solve012;

import java.io.*;
import java.util.*;

public class boj_14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] input;
    static int[] operand;
    static Stack<Integer> stack = new Stack<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        input = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int operIdx = 0; // 0 +, 1 -, 2 * ,3/
        int idx = 0;
        operand = new int[n - 1];
        while (st.hasMoreTokens()) {
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt == 0) {
                operIdx++;
                continue;
            }
            while (cnt != 0) {
                operand[idx++] = operIdx;
                cnt--;
            }
            operIdx++;
        }

        recur(0, n - 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void recur(int start, int end) {
        if (start == end) {
            int idx = 1;
            int result = input[0];
            for (int val : stack) {
                if (val == 0) {
                    result += input[idx++];
                }
                else if (val == 1) {
                    result -= input[idx++];
                }
                else if (val == 2) {
                    result *= input[idx++];
                }
                else if (val == 3) {
                    result /= input[idx++];
                }
            }
            if (result >= max) {
                max = result;
            }
            if (result <= min) {
                min = result;
            }
            return ;
        }
        for (int i = 0; i < operand.length; i++) {
            if (operand[i] >= 0) {
                stack.push(operand[i]);
                operand[i] = -1;
                recur(start + 1, end);
                operand[i] = stack.pop();
            }
        }
    }
}
