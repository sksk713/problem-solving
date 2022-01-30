package Solve011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2792 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] jewel = new int[m];
        int maxVal = 0;

        for (int i = 0; i < m; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            if (maxVal < jewel[i]) {
                maxVal = jewel[i];
            }
        }

        int left = 1;
        int right = maxVal;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            int sum = 0;
            for (int i : jewel) {
                sum += (int)Math.ceil((double)i / (double)mid);
            }

            if (n >= sum) {
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        System.out.println(left);
    }
}
