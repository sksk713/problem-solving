package Solve007;

import java.io.*;
import java.util.*;

public class boj_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] visit;
    static List<point> virus = new ArrayList<>();
    static int n;
    static int m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    virus.add(new point(i, j));
                }
            }
        }

        dfs(0, 3);
        System.out.println(max);
    }

    static void dfs (int start, int end) {
        if (start == end) {
            int[][] newArr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newArr[i][j] = arr[i][j];
                }
            }

            Queue<point> qu = new LinkedList<>();

            for (point x : virus) {
                qu.add(x);
            }

            while (!qu.isEmpty()) {
                point p = qu.poll();

                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];

                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        if (newArr[x][y] == 2 || newArr[x][y] == 1) {
                            continue;
                        }
                        newArr[x][y] = 2;
                        qu.add(new point(x, y));
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (newArr[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            if (max < cnt) {
                max = cnt;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && arr[i][j] == 0) {
                        visit[i][j] = true;
                        arr[i][j] = 1;
                        dfs (start + 1, end);
                        visit[i][j] = false;
                        arr[i][j] = 0;
                    }
                }
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