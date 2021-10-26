package Solve006;

import java.util.*;
import java.io.*;

public class boj_1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[] password;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int passLen = Integer.parseInt(st.nextToken());
        int wordCnt = Integer.parseInt(st.nextToken());

        password = new char[wordCnt];
        visited = new boolean[wordCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < wordCnt; i++) {
            password[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(password);

        dfs(0, 0, passLen);
    }

    static void dfs(int start, int wordCnt, int n) {

        int consonant = 0;
        int vowel = 0;
        cnt = 0;
        if (wordCnt == n) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(password[i]);
                }
            }
            for (int i = 0; i < sb.toString().length(); i++) {
                char x = sb.toString().charAt(i);
                if (x == 97 || x == 101 || x == 105 || x == 111 || x == 117) {
                    vowel++;
                }
                else
                    consonant++;
            }

            if (vowel < 1 || consonant < 2) {
                return;
            }
            System.out.println(sb);
        }
        else {
            for (int i = start; i < password.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i, wordCnt + 1, n);
                    visited[i] = false;
                }
            }
        }
    }
}
