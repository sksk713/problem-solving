package Solve003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int flag = 0;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

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
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    static void recur(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != arr[x][y]) {
                    recur(x, y, n / 3); // 첫번째 조각
                    recur(x + n / 3 , y, n / 3); // 두번째 조각
                    recur(x + 2 * (n / 3), y, n / 3); // 세번째 조각
                    recur(x, y + n / 3, n / 3); // 4
                    recur(x + n / 3, y + n / 3, n / 3); // 5
                    recur(x + 2 * (n / 3), y + n / 3, n / 3); // 6
                    recur(x, y + 2 * (n / 3), n / 3); // 7
                    recur(x + n / 3, y + 2 * (n / 3), n / 3); // 8
                    recur(x + 2 * (n / 3), y + 2 * (n / 3), n / 3);// 9

                    return;
                }
                if(arr[i][j] == -1){
                    flag = -1;
                }
                else if(arr[i][j] == 0){
                    flag = 0;
                }
                else if(arr[i][j] == 1){
                    flag = 1;
                }
            }
        }
        if (flag == -1)
            minus++;
        else if (flag == 0)
            zero++;
        else if (flag == 1)
            plus++;
    }
}
