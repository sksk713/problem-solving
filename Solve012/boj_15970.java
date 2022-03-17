package Solve012;

import java.util.*;
import java.io.*;

public class boj_15970 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Obj implements Comparable<Obj> {
        int pos, color;

        @Override
        public int compareTo(Obj o) {
            if (color == o.color) {
                return pos - o.pos;
            }
            else {
                return color - o.color;
            }
        }
    }

    static int solve() {
        Arrays.sort(s);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum += Math.abs(s[i + 1].pos - s[i].pos);
            }
            else if (i == n - 1) {
                sum += Math.abs(s[i].pos - s[i - 1].pos);
            }
            else {
                if (s[i + 1].color == s[i].color && s[i].color == s[i - 1].color)
                    sum += Math.min(Math.abs(s[i + 1].pos - s[i].pos), Math.abs(s[i].pos - s[i - 1].pos));
                else if (s[i + 1].color != s[i].color && s[i].color == s[i - 1].color)
                    sum += Math.abs(s[i].pos - s[i - 1].pos);
                else if (s[i + 1].color == s[i].color && s[i].color != s[i - 1].color)
                    sum += Math.abs(s[i + 1].pos - s[i].pos);
            }
        }

        return sum;
    }

    static int n;
    static Obj[] s;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        s = new Obj[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = new Obj();
            s[i].pos = Integer.parseInt(st.nextToken());
            s[i].color = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve());

    }
}
