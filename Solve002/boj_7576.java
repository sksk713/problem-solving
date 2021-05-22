package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static Queue<Point> qu = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        arr = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS(arr));


    }

    static int BFS(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    qu.add(new Point(i, j));
                }
            }
        }
        while (!qu.isEmpty()) {
            Point point = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nextx = point.x + dx[i];
                int nexty = point.y + dy[i];

                if (nextx >= arr.length || nextx < 0 || nexty >= arr[0].length || nexty < 0 || arr[nextx][nexty] != 0) {
                    continue;
                }
                arr[nextx][nexty] = arr[point.x][point.y] + 1;
                qu.add(new Point(nextx, nexty));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max - 1;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}