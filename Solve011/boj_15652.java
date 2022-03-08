package Solve011;

import java.io.*;
import java.util.*;

public class boj_15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] select;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        select = new int[m + 1];

        solve(1);
        System.out.println(sb);
    }

    static void solve(int x) {
        if (x == m + 1) {
            for (int i = 1; i < x; i++) {
                sb.append(select[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            boolean isBigger = false;
            for (int j = 1; j < x; j++) {
                if (select[j] > i) {
                    isBigger = true;
                    break;
                }
            }
            if (isBigger) continue;
            select[x] = i;
            solve(x + 1);
        }
    }
}
