package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] arr;
    static Queue<newpoint> qu = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        arr = new int[z][y][x];

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < x; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.println(BFS(x, y, z));
    }

    static int BFS(int x, int y, int z){
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if(arr[i][j][k] == 1){
                        qu.add(new newpoint(k, j, i));
                    }
                }
            }
        }
        while(!qu.isEmpty()){
            newpoint po = qu.poll();
            for (int i = 0; i < 6; i++) {
                int nextx = po.x + dx[i];
                int nexty = po.y + dy[i];
                int nextz = po.z + dz[i];

                if(nextx >= x || nextx < 0 || nexty >= y || nexty < 0 || nextz >= z || nextz < 0 || arr[nextz][nexty][nextx] != 0){
                    continue;
                }

                arr[nextz][nexty][nextx] = arr[po.z][po.y][po.x] + 1;
                qu.add(new newpoint(nextx, nexty, nextz));
            }

        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                    if (arr[i][j][k] > max) {
                        max = arr[i][j][k];
                    }
                }
            }
        }
        return max - 1;
    }
}

class newpoint {
    int x;
    int y;
    int z;

    public newpoint (int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}