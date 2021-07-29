package Solve007;

import java.io.*;
import java.util.*;

public class boj_10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] arr;
    static boolean[][] visit;
    static Queue<point2> qu = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt1 = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs1(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs2(i, j);
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);

    }

    static void bfs1(int x, int y) {
        visit[x][y] = true;
        qu.add(new point2(x, y));
        char a = arr[x][y];

        while (!qu.isEmpty()) {
            point2 p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr.length && !visit[newX][newY]) {
                    if (a == arr[newX][newY]) {
                        qu.add(new point2(newX, newY));
                        visit[newX][newY] = true;
                    }
                }
            }
        }
        cnt1++;
        return;
    }

    static void bfs2(int x, int y) {
        visit[x][y] = true;
        qu.add(new point2(x, y));
        char a = arr[x][y];

        while (!qu.isEmpty()) {
            point2 p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr.length && !visit[newX][newY]) {
                    if (a == arr[newX][newY]) {
                        qu.add(new point2(newX, newY));
                        visit[newX][newY] = true;
                    }
                    else if ((a == 'R' && arr[newX][newY] == 'G') || (a == 'G' && arr[newX][newY] == 'R')) {
                        qu.add(new point2(newX, newY));
                        visit[newX][newY] = true;
                    }
                }
            }
        }
        cnt2++;
        return;
    }
}
class point2 {
    int x;
    int y;

    public point2 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
