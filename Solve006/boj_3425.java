package Solve006;

import java.io.*;
import java.util.*;

public class boj_3425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> instr = new ArrayList<>();
    static StringTokenizer st;
    static Stack<Integer> stack = new Stack<>();

    static int oper(int n) {
        for (int i = 0; i < instr.size(); i++) {
            String input = instr.get(i);

            if (input.equals("DUP")) {
                if (stack.size() == 0) {
                    return -1;
                }
                stack.add(stack.peek());
            }
            else if (input.equals("POP")) {
                if (stack.size() == 0) {
                    return -1;
                }
                stack.pop();
            }
            else if (input.equals("INV")) {
                if (stack.size() == 0) {
                    return -1;
                }
                int num = stack.pop();
                stack.add(-num);
            }
            else if (input.equals("SWP")) {
                if (stack.size() < 2) {
                    return -1;
                }
                int temp = stack.pop();
                int temp2 = stack.pop();
                stack.add(temp);
                stack.add(temp2);
            }
            else if (input.equals("ADD")) {
                if (stack.size() < 2) {
                    return -1;
                }
                long temp = stack.pop();
                long temp2 = stack.pop();
                temp2 += temp;

                if (temp2 > 1000000000)
                    return -1;
                int newTemp2 = (int)temp2;

                stack.add(newTemp2);

            }
            else if (input.equals("SUB")) {
                if (stack.size() < 2) {
                    return -1;
                }
                long temp = stack.pop();
                long temp2 = stack.pop();
                temp2 -= temp;

                if (temp2 < -1000000000)
                    return -1;

                int newTemp2 = (int)temp2;

                stack.add(newTemp2);
            }
            else if (input.equals("MUL")) {
                if (stack.size() < 2) {
                    return -1;
                }

                long temp = stack.pop();
                long temp2 = stack.pop();
                temp2 *= temp;

                if (temp2 > 1000000000)
                    return -1;

                int newTemp2 = (int)temp2;
                stack.add(newTemp2);

            }
            else if (input.equals("DIV")) {
                if (stack.size() < 2) {
                    return -1;
                }
                int minusCnt = 0;
                int temp = stack.pop();
                if (temp == 0) {
                    return -1;
                }
                if (temp < 0) {
                    minusCnt++;
                }
                int temp2 = stack.pop();
                if (temp2 < 0) {
                    minusCnt++;
                }

                if (temp < 0) {
                    if (temp2 > 0) {
                        temp2 /= Math.abs(temp);
                    }
                    else {
                        temp2 = Math.abs(temp2) / Math.abs(temp);
                    }
                }
                else {
                    if (temp2 > 0) {
                        temp2 /= temp;
                    }
                    else {
                        temp2 = Math.abs(temp2) / temp;
                    }
                }

                if (minusCnt == 1) {
                    temp2 = -temp2;
                }
                stack.add(temp2);
            }
            else if (input.equals("MOD")) {
                if (stack.size() < 2) {
                    return -1;
                }
                int temp = stack.pop();
                if (temp == 0) {
                    return -1;
                }
                int temp2 = stack.pop();
                if (temp < 0) {
                    if (temp2 > 0) {
                        temp2 %= Math.abs(temp);
                        temp2 = temp2;
                    }
                    else {
                        temp2 = Math.abs(temp2) % Math.abs(temp);
                        temp2 = -temp2;
                    }
                }
                else {
                    if (temp2 > 0) {
                        temp2 %= temp;
                    }
                    else {
                        temp2 = Math.abs(temp2) % temp;
                        temp2 = -temp2;
                    }
                }
                stack.add(temp2);;
            }
            else if(input.contains("NUM")) {
                StringBuilder s = new StringBuilder(input);
                s.delete(0, 3);
                if (Integer.parseInt(s.toString()) > 1000000000)
                    return -1;
                stack.add(Integer.parseInt(s.toString()));
            }
        }
        if (stack.size() != 1) {
            return -1;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException{
        while (true) {
            while (true) {
                st = new StringTokenizer(br.readLine());
                String input = st.nextToken();

                if (input.equals("NUM")) {
                    String num = st.nextToken();
                    String newInput = input + num;
                    instr.add(newInput);
                }
                else if (input.equals("END")) {
                    break;
                }
                else if (input.equals("QUIT")) {
                    return;
                }
                else {
                    instr.add(input);
                }
            }

            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                int initValue = Integer.parseInt(br.readLine());
                stack.add(initValue);
                int output = oper(initValue);
                if (output == -1) {
                    System.out.println("ERROR");
                }
                else
                    System.out.println(stack.peek());

                stack.clear();

            }
            br.readLine();
            System.out.println();

            instr.clear();
        }
    }
}
