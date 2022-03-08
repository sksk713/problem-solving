package Solve011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] select;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        select = new int[m + 1];
        check = new boolean[n + 1];

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
            if (!check[i]) {
                select[x] = i;
                check[i] = true;
                solve(x + 1);
                check[i] = false;
            }
        }
    }
}
