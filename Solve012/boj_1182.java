package Solve012;

import java.util.*;
import java.io.*;

public class boj_1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int cnt = 0;

    static int n;
    static int s;
    static int[] arr;
    static boolean[] check;
    static Stack<Integer> stack = new Stack<>();

    static void solve(int start, int end, int idx) {
        if (start == end) {
            int sum = 0;
            for (int i : stack) {
                System.out.println(i);
                sum += i;
            }
            System.out.println();
            if (sum == s) {
                cnt++;
            }
        }
        else {
            for (int i = idx; i < n; i++) {
                if (!check[i]) {
                    stack.push(arr[i]);
                    check[i] = true;
                    solve(start + 1, end, i);
                    stack.pop();
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        check = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            solve(0, i, 0);
            stack.clear();
        }
        System.out.println(cnt);
    }
}
