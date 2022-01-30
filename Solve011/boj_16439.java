package Solve011;

import java.io.*;
import java.util.*;

public class boj_16439 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int sum = 0;
    static List<int[]> list = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws  IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        check = new boolean[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] sat = new int[m];
            int idx = 0;

            while (st.hasMoreTokens()) {
                sat[idx++] = Integer.parseInt(st.nextToken());
            }
            list.add(sat);
        }
        dfs(0, 3, m);
        System.out.println(sum);
    }

    static void dfs(int start, int end, int chLen) {
        if (start == end) {
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                int maxVal = 0;
                for (int j = 0; j < list.get(i).length; j++) {
                    if (check[j] && maxVal < list.get(i)[j]) {
                        maxVal = list.get(i)[j];
                    }
                }
                max += maxVal;
                if (sum < max) {
                    sum = max;
                }
            }
            return ;
        }
        for (int i = 0; i < chLen; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(start + 1, end, chLen);
                check[i] = false;
            }
        }
    }
}
