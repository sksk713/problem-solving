package Solve009;

import java.io.*;
import java.util.*;

public class boj_16234 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean isMove;
    static int[][] country;
    static boolean[][] visit;
    static Queue<Point> qu = new LinkedList<>();
    static Queue<Point> union = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        country = new int[n][n];
        visit = new boolean[n][n];
        int dayCnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        bfs(new Point(i, j), l, r);
                    }
                }
            }
            if (isMove)
                dayCnt++;
            else
                break;
            for (int i = 0; i < n; i++)
                Arrays.fill(visit[i], false);
            isMove = false;
        }
        System.out.println(dayCnt);
    }

    public static void bfs(Point p, int l, int r) {
        qu.add(p);
        union.add(p);
        visit[p.x][p.y] = true;
        int sum = country[p.x][p.y];
        int cnt = 1;
        boolean flag = false;

        while (!qu.isEmpty()) {
            Point point = qu.poll();
            for (int k = 0; k < 4; k++) {
                int newX = point.x + dx[k];
                int newY = point.y + dy[k];

                if (newX < 0 || newX >= country.length || newY < 0 || newY >= country.length)
                    continue;
                if (visit[newX][newY])
                    continue;
                if (Math.abs(country[point.x][point.y] - country[newX][newY]) >= l && Math.abs(country[point.x][point.y] - country[newX][newY]) <= r) {
                    sum += country[newX][newY];
                    cnt++;
                    qu.add(new Point(newX, newY));
                    union.add(new Point(newX, newY));
                    visit[newX][newY] = true;
                    flag = true;
                }
            }
        }
        if (flag) {
            move(sum / cnt);
            isMove = true;
        }
        union.clear();
    }
    public static void move(int newVal) {
        for (Point p : union) {
            country[p.x][p.y] = newVal;
        }
    }

    static class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
