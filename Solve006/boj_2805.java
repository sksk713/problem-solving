package Solve006;

import java.io.*;
import java.util.*;

public class boj_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        tree = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        long left = 0;
        long right = tree[tree.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }
            if (sum == h) {
                System.out.println(mid);
                return;
            }
            else if (sum > h) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
