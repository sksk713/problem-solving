package Solve012;

import java.util.*;
import java.io.*;

public class boj_11652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static long[] in;
    static long maxVal;
    static long maxCnt;
    static long curCnt;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        in = new long[n];

        for (int i = 0; i < n; i++) {
            in[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(in);
        maxVal = in[0];
        curCnt = 1;
        maxCnt = 1;

        for (int i = 1; i < n; i++) {
            if (in[i] != in[i - 1]) {
                curCnt = 1;
            }
            else {
                curCnt++;
            }

            if (maxCnt < curCnt) {
                maxCnt = curCnt;
                maxVal = in[i];
            }
        }

        System.out.println(maxVal);
    }
}
