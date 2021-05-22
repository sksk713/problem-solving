package Solve001;

import java.util.Scanner;

public class boj_1080 {
    static int n;
    static int m;
    static int cnt = 0;
    static int[][] a;
    static int[][] b;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        a = new int[n][m];
        b = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = stdin.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String str = stdin.next();
            for (int j = 0; j < m; j++) {
                b[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(solution());
    }

    static void reverse(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (a[i][j] == 1) {
                    a[i][j] = 0;
                }
                else {
                    a[i][j] = 1;
                }

            }
        }
    }

    static int solution(){
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    reverse(i, j);
                    cnt++;
                }
            }
        }
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    return -1;
                }
            }
        }

        return cnt;
    }
}
