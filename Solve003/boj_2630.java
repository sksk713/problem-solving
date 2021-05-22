package Solve003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static boolean flag;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    static void recur(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != arr[x][y]) {
                    recur(x, y, n / 2);
                    recur(x + n / 2, y, n / 2);
                    recur(x, y + n / 2, n / 2);
                    recur(x + n / 2, y + n / 2, n / 2);

                    return;
                }
                if(arr[i][j] == 1){
                    flag = true;
                }
                else if(arr[i][j] == 0){
                    flag = false;
                }
            }
        }
        if (flag == true)
            blue++;
        else
            white++;
    }
}
