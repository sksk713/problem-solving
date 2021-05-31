package Solve004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int[][] sumArr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        sumArr = new int[n + 1][n + 1];

        int temp = 0;

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sumArr[i][j] = temp + arr[i][j];
                temp = sumArr[i][j];
            }
            temp = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sumArr[i][j] += sumArr[i - 1][j];
            }
        }

        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            System.out.println(solution(x1, y1, x2, y2));
        }
    }

    static int solution(int x1, int y1, int x2, int y2) {
        int result = 0;

        if (x1 == x2 && y1 == y2) {
            result = arr[x1][y1];
        }
        else {
            result = sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1 - 1][y1 - 1];
        }

        return result;
    }

}
