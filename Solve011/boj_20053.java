package Solve011;

import java.io.*;
import java.util.*;

public class boj_20053 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[m];

            int idx = 0;
            while (st.hasMoreTokens())
                arr[idx++] = Integer.parseInt(st.nextToken());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int val : arr) {
                if (val < min) {
                    min = val;
                }
                if (val > max) {
                    max = val;
                }
            }
            System.out.println(min + " " + max);
        }
    }
}
