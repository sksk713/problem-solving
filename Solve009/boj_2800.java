package Solve009;

import java.io.*;
import java.util.*;

public class boj_2800 {
    static Set<String> result = new TreeSet<>();
    static List<bracketPos> bracket = new ArrayList<>();
    static boolean[] check;

    public static void delete(int start, int end, String input) {
        if (start == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (!check[i])
                    sb.append(input.charAt(i));
            }
            result.add(sb.toString());
            return ;
        }
        for (int i = start; i < bracket.size(); i++) {
            if (!check[bracket.get(i).left]) {
                check[bracket.get(i).left] = true;
                check[bracket.get(i).right] = true;
                delete(start + 1, end, input);
                check[bracket.get(i).left] = false;
                check[bracket.get(i).right] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        check = new boolean[input.length()];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                st.add(i);
            else if (input.charAt(i) == ')') {
                int first = st.pop();
                bracket.add(new bracketPos(first, i));
            }
        }
        for (int i = 1; i <= bracket.size(); i++) {
            delete(0, i, input);
            Arrays.fill(check, false);
        }
        for (String x : result) {
            System.out.println(x);
        }
    }

    public static class bracketPos {
        int left;
        int right;

        public bracketPos(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
