package Solve004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11053 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] input;
    static int[] result;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        input = new int[n];
        result = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution());
    }

    static int solution() {

        result[0] = 1;
        for (int i = 1; i < input.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i] && result[i] <= result[j]) {
                    result[i] = result[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (max < result[i]) {
                max = result[i];
            }
        }
        return max;
    }
}