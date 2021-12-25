package Solve009;

import java.util.*;

public class 단체사진찍기 {
    static Stack<Character> line = new Stack<>();
    static boolean[] visit = new boolean[8];
    static char[] fr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int cnt = 0;

    public static void main(String[] args) {
        String[] x = {"N~F=0", "R~T>2"};
        System.out.println(solution(2, x));
    }
    public static int solution(int n, String[] data) {
        int answer = 0;
        cnt = 0;
        dfs(0, 8, n, data);
        answer = cnt;
        return answer;
    }

    public static void dfs(int startCnt, int endCnt, int n ,String[] data) {
        if (startCnt == endCnt) {
            if (isOk(n, data))
                cnt++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                line.push(fr[i]);
                dfs(startCnt + 1, 8, n, data);
                visit[i] = false;
                line.pop();
            }
        }
    }

    public static boolean isOk(int n, String[] data) {
        for (int i = 0; i < n; i++) {
            char first = data[i].charAt(0);
            char last = data[i].charAt(2);
            char oper = data[i].charAt(3);
            int distance = data[i].charAt(4) - '0';

            if (oper == '>' && Math.abs(line.indexOf(first) - line.indexOf(last)) - 1 <= distance) {
                return false;
            }
            else if (oper == '=' && Math.abs(line.indexOf(first) - line.indexOf(last)) - 1 != distance) {
                return false;
            }
            else if (oper == '<' && Math.abs(line.indexOf(first) - line.indexOf(last)) - 1 >= distance) {
                return false;
            }
        }
        return true;
    }
}
