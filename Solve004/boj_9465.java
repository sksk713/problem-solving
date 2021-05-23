package Solve004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[2][n];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[1][j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(solution(n));
        }
    }

    static int solution(int length) {
        int firstMax = arr[0][0];
        int secondMax = arr[1][0];
        for (int i = 1; i < length; i++) {
            int nextFirstValue = arr[0][i] + secondMax;
            arr[0][i] += secondMax;

            int nextSecondValue = arr[1][i] + firstMax;
            arr[1][i] += firstMax;

            if (firstMax < nextFirstValue) {
                firstMax = nextFirstValue;
            }

            if (secondMax < nextSecondValue) {
                secondMax = nextSecondValue;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
}
