package Solve005;

import java.io.*;
import java.util.*;

public class boj_3055 {
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] cnt;
    static List<Boolean>[] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<point> waterQu = new LinkedList<>();
    static Queue<point> ddgQu = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(sc.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int obX = 0;
        int obY = 0;

        cnt = new ArrayList[r];
        visited = new ArrayList[r];

        for (int i = 0; i < r; i++) {
            cnt[i] = new ArrayList<>();
            visited[i] = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                cnt[i].add(0);
                visited[i].add(false);
            }
        }

        for (int i = 0; i < r; i++) {
            String s = sc.readLine();

            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == '*') {
                    visited[i].set(j, true);
                    waterQu.offer(new point(i, j));
                }
                if (s.charAt(j) == 'S') {
                    cnt[i].set(j, 1);
                    ddgQu.offer(new point(i, j));
                }
                if (s.charAt(j) == 'D') {
                    obX = i;
                    obY = j;
                }
                if (s.charAt(j) == 'X') {
                    cnt[i].set(j, -2);
                }
            }
        }


        bfs(r, c, obX, obY);
    }

    static void bfs(int r, int c, int obX, int obY) {

        while (true) {
            int wqSize = waterQu.size();

            while (wqSize != 0) {
                point p = waterQu.poll();

                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];

                    if (0 <= x && x < cnt.length && 0 <= y && y < cnt[0].size()) {
                        if (x == obX && y == obY || visited[x].get(y)) {
                            continue;
                        }
                        if (cnt[x].get(y) != -2) {
                            visited[x].set(y, true);
                            waterQu.offer(new point(x, y));
                        }

                    }
                }
                wqSize--;
            }

            int dqSize = ddgQu.size();
            while (dqSize != 0) {
                point ddg = ddgQu.poll();

                for (int i = 0; i < 4; i++) {
                    int x = ddg.x + dx[i];
                    int y = ddg.y + dy[i];

                    if (0 <= x && x < cnt.length && 0 <= y && y < cnt[0].size()) {
                        if (visited[x].get(y) || cnt[x].get(y) != 0)
                            continue;
                        if (x == obX && y == obY) {
                            System.out.println(cnt[ddg.x].get(ddg.y));
                            return;
                        }
                        cnt[x].set(y, cnt[ddg.x].get(ddg.y) + 1);
                        ddgQu.offer(new point(x, y));
                    }
                }
                dqSize--;
            }

            if (ddgQu.isEmpty()) {
                System.out.println("KAKTUS");
                return;
            }

        }
    }
}
class point {
    int x;
    int y;

    public point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}