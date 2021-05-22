package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] visited;
    static int x = 0;
    static int y = 0;
    static int count = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            count = 0;
            arr = new int[y][x];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a] = 1;
            }
            for (int k = 0; k < y; k++) {
                for (int l = 0; l < x; l++) {
                    if (arr[k][l] == 1) {
                        DFS(k, l);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void DFS(int X, int Y) {
        for (int i = 0; i < 4; i++) {
            int new_x = X + dx[i];
            int new_y = Y + dy[i];

            if (new_x < 0 || new_y < 0 || new_x >= y || new_y >= x) {
                continue;
            }
            if (arr[new_x][new_y] == 0) {
                continue;
            }

            arr[new_x][new_y] = 0;
            DFS(new_x, new_y);
        }
    }
}
