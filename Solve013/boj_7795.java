package Solve013;

import java.util.*;
import java.io.*;

public class boj_7795 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int solve() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            int res = 0;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (b[mid] < a[i]) {
                    left = mid + 1;
                    res = left;
                }
                else {
                    right = mid - 1;
                }
            }
            sum += res;
        }
        return sum;
    }
    static int t, n, m;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n];
            b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);
            System.out.println(solve());
        }

    }
}
