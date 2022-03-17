package Solve012;

import java.util.*;
import java.io.*;

public class boj_1015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Obj implements Comparable<Obj> {

        int num, idx;

        @Override
        public int compareTo(Obj o) {
            return num - o.num;
        }
    }
    static void solve() {
        Arrays.sort(s);

        for (int i = 0; i < s.length; i++) {
            ans[s[i].idx] = i;
        }
    }

    static int n;
    static Obj[] s;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        s = new Obj[n];
        ans = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = new Obj();
            s[i].num = Integer.parseInt(st.nextToken());
            s[i].idx = i;

        }
        solve();
        for (int val : ans) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString());
    }
}
