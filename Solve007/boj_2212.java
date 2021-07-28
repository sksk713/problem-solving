package Solve007;

import java.io.*;
import java.util.*;

public class boj_2212 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> base = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (n <= k) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (base.contains(x)) {
                continue;
            }
            base.add(x);
        }

        Collections.sort(base);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < base.size() - 1; i++) {
            int x = base.get(i + 1) - base.get(i);
            list.add(x);
        }

        Collections.sort(list);

        for (int i = 0; i < k - 1; i++) {
            list.remove(list.size() - 1);
        }

        int sum = 0;
        for (int a : list) {
            sum += a;
        }
        System.out.println(sum);
    }
}