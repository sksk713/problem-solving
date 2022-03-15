package Solve012;

import java.io.*;
import java.util.*;

public class boj_9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] col;
    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        col = new int[n];

        Arrays.fill(col, -1);
        choice(0, n);
        System.out.println(cnt);
    }

    static void choice(int start, int end) {
        if (start == end) {
            cnt++;
        }
        else {
            for (int i = 0; i < col.length; i++) {
                boolean possible = false;
                for (int j = 0; j < start; j++) {
                    if (isNQueen(i, j, start)) {
                        possible = true;
                        break;
                    }
                }
                if (!possible) {
                    col[start] = i;
                    choice(start + 1, end);
                    col[start] = -1;
                }
            }
        }
    }
    static boolean isNQueen(int i, int j, int idx) {
        if (col[j] == i)
            return true;
        else if (idx - i == j - col[j])
            return true;
        else if (idx + i == j + col[j])
            return true;
        return false;
    }
}
