package Solve013;

import java.util.*;
import java.io.*;

public class boj_2470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int bn(int l, int r, int k) {
        int res = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= k) {
                res = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return res;
    }

    static int n;
    static int[] arr;
    static int sum = Integer.MAX_VALUE;
    static int x, y;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            int res = bn(i + 1, n - 1, -arr[i]);
            if (Math.abs(arr[i] + arr[res]) < sum) {
                sum = Math.abs(arr[i] + arr[res]);
                x = arr[i];
                y = arr[res];
            }

            if (i < res - 1 && Math.abs(arr[i] + arr[res - 1]) < sum) {
                sum = Math.abs(arr[i] + arr[res - 1]);
                x = arr[i];
                y = arr[res - 1];
            }
        }
        System.out.println(x + " " + y);

    }
}
