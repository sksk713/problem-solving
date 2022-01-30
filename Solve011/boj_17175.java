package Solve011;

import java.io.*;

public class boj_17175 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp = new long[51];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        if (n < 4) {
            System.out.println(dp[n]);
        }
        else {
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 2] + dp[i - 1] + 1;
            }
            System.out.println(dp[n] % 1000000007);
        }
    }
}
