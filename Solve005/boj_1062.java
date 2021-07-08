package Solve005;

import java.io.*;
import java.util.*;

public class boj_1062 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<String> word;
    static boolean[] alpha = new boolean[26];
    static int cnt = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        word = new ArrayList<>();

        alpha['a' - 97] = true;
        alpha['n' - 97] = true;
        alpha['t' - 97] = true;
        alpha['i' - 97] = true;
        alpha['c' - 97] = true;


        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            word.add(input.substring(4, input.length() - 4));
        }

        if (k < 5) {
            System.out.println(0);
        }
        else {
            dfs(0, 0, k - 5);
            System.out.println(max);
        }
        return;
    }

    static void dfs(int start, int wordCnt, int end) {
        cnt = 0;
        if (wordCnt == end) {
            for (int i = 0; i < word.size(); i++) {
                boolean isIn = false;
                String x = word.get(i);

                for (int j = 0; j < x.length(); j++) {
                    char y = x.charAt(j);
                    if (alpha[y - 97]) {
                        continue;
                    }
                    else {
                        isIn = true;
                        break;
                    }
                }
                if (!isIn) {
                    cnt++;
                }

            }

            if (max < cnt) {
                max = cnt;
            }
            return;
        }
        else {
            for (int i = start; i < 26; i++) {
                if (!alpha[i]) {
                    alpha[i] = true;
                    dfs(i, wordCnt + 1, end);
                    alpha[i] = false;
                }
            }
        }

    }
}
