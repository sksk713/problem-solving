package Solve013;

import java.util.*;
import java.io.*;

public class boj_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int solve() {
        int l = 0, r = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (r != n) {
            sum += arr[r];
            while (sum >= s) {
                if (len > (r - l + 1)) {
                    len = (r - l + 1);
                }
                sum -= arr[l];
                l++;
            }
            r++;
        }
        return len;
    }

    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int res = solve();
        if (res == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else
            System.out.println(res);
    }
}
