package Solve013;

import java.util.*;
import java.io.*;

public class boj_4803 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    static int n, m, cnt;
    static int vCnt, eCnt;
    static int ans;
    static boolean[] visit;

    static void dfs(int i) {
        vCnt++;
        eCnt += list[i].size();
        visit[i] = true;
        for (int x : list[i]) {
            if (visit[x])
                continue;
            dfs(x);
        }
    }

    public static void main(String[] args) throws IOException {
        cnt = 1;
        while (true) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];
            visit = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }
            if (n == 0 && m == 0)
                break;

            for (int i = 1; i <= n; i++) {
                if (visit[i])
                    continue;
                vCnt = 0;
                eCnt = 0;
                dfs(i);
                if (eCnt == (vCnt - 1) * 2) {
                    ans++;
                }
            }
            sb.append("Case ").append(cnt).append(": ");
            if (ans == 0) {
                sb.append("No trees.\n");
            }
            else if (ans == 1) {
                sb.append("There is one tree.\n");
            }
            else
                sb.append("A forest of ").append(ans).append(" trees.\n");
            cnt++;
        }
        System.out.println(sb);
    }
}
