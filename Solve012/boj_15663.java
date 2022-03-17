package Solve012;

import java.util.*;
import java.io.*;

public class boj_15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Integer> stack = new Stack<>();
    static Set<ArrayList<Integer>> answer = new HashSet<>();
    static boolean[] check;

    static void solve(int depth) {
        if (depth == m) {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(stack);
            if (!answer.contains(list)) {
                answer.add(list);
                for (int i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        else {
            for (int i = 0; i < input.length; i++) {
                if (!check[i]) {
                    stack.push(input[i]);
                    check[i] = true;
                    solve(depth + 1);
                    stack.pop();
                    check[i] = false;
                }
            }
        }
    }

    static int n, m;
    static int[] input;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        solve(0);
    }
}
