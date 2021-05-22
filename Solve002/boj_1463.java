package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class boj_1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        System.out.println(solution(n));
    }

    static int solution(int n) {
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i / 3] + 1;
            }
            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i / 2] + 1;
            }
        }
        return dp[n];
    }
}
