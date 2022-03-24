package Solve013;

import java.util.*;
import java.io.*;

public class boj_2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Integer>[] list;
    static Queue<Integer> qu = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] inDeg;
    static int n, m;

    static void tSort() {
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0) {
                qu.add(i);
            }
        }
        while (!qu.isEmpty()) {
            int poll = qu.poll();
            sb.append(poll).append(" ");

            for (int i : list[poll]) {
                inDeg[i]--;
                if (inDeg[i] == 0) {
                    qu.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        inDeg = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            inDeg[y]++;
        }
        tSort();
        System.out.println(sb);
    }
}