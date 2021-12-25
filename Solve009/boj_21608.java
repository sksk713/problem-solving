package Solve009;

import java.io.*;
import java.util.*;

public class boj_21608 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] order;
    static int[][] seat;
    static List<Integer>[] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        order = new int[n * n];
        seat = new int[n][n];
        map = new ArrayList[n * n + 1];
        for (int i = 1; i <= n * n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[i] = new ArrayList<>();
            int cur = Integer.parseInt(st.nextToken());
            order[i - 1] = cur;
            map[i].add(Integer.parseInt(st.nextToken()));
            map[i].add(Integer.parseInt(st.nextToken()));
            map[i].add(Integer.parseInt(st.nextToken()));
            map[i].add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < 2; i++) {
            pickSeat(n , order[i]);
        }
    }

    public static void pickSeat(int n, int student) {
        boolean flag = false;
        int maxCnt = 0;
        int cnt = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                        continue;
                    }
                    cnt++;
                    if (map[student].contains(seat[newX][newY])) {
                        flag = true;
                    }
                    else if (!flag) {
                        if (cnt > maxCnt) {
                            maxCnt = cnt;
                            x = i;
                            y = j;
                        }
                    }
                }
                System.out.println(cnt);
            }
        }
        System.out.println(x + " " + y);
    }
}
