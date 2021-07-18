package Solve007;

import java.io.*;
import java.util.*;

public class boj_15810 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] x = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            x[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(x);

        long left = 0;
        long right = x[x.length - 1] * m;
        long mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 0; i < x.length; i++) {
                cnt += mid / x[i];
            }

            if (cnt >= m) {
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        System.out.println(left);
    }
}
