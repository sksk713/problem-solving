package Solve012;

import java.util.*;
import java.io.*;

public class boj_10825 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Obj implements Comparable<Obj> {

        public String name;
        public int k, e, m;

        @Override
        public int compareTo(Obj o) {
            if (k != o.k) {
                return o.k - k;
            }
            else if (e != o.e) {
                return e - o.e;
            }
            else if (m != o.m) {
                return o.m - m;
            }
            return name.compareTo(o.name);
        }
    }

    static int n;
    static Obj[] s;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        s = new Obj[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = new Obj();
            s[i].name = st.nextToken();
            s[i].k = Integer.parseInt(st.nextToken());
            s[i].e = Integer.parseInt(st.nextToken());
            s[i].m = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);
        for (int i = 0; i < n; i++) {
            sb.append(s[i].name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
