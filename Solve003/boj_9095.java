package Solve003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] result;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        result = new int[11];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for(int i = 4; i < 11; i++){
            result[i] = result[i - 3] + result[i - 2] + result[i - 1];
        }
        for(int i = 0; i < n; i++){
            System.out.println(result[Integer.parseInt(br.readLine())]);
        }
    }
}
