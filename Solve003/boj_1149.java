package Solve003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        arr = new int[T][3];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) { //red:0 ,green:1, blue:2
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(T));
    }

    static int solution(int T) {
        for (int i = 1; i < T; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (min > arr[T - 1][i]) {
                min = arr[T - 1][i];
            }
        }
        return min;
    }
}