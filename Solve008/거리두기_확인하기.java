package Solve008;

import java.util.*;

class 거리두기_확인하기 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> qu = new LinkedList<>();
    static boolean flag;
    static boolean[][] visit = new boolean[5][5];

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            flag = false;
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    visit[x][y] = false;
                }
            }
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P' && !visit[j][k])
                        bfs(j, k, places[i]);
                }
            }
            if (!flag)
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }
    public static void bfs(int x, int y, String[] p) {
        qu.add(new int[] {x, y});
        visit[x][y] = true;

        while (!qu.isEmpty()) {
            int[] arr = qu.poll();

            for (int i = 0; i < 4; i++) {
                int newX = arr[0] + dx[i];
                int newY = arr[1] + dy[i];

                if (newX >= 0 && newX <= 4 && newY >= 0 && newY <= 4 && !visit[newX][newY]) {
                    int distance = Math.abs(newX - x) + Math.abs(newY - y);
                    if (p[newX].charAt(newY) == 'P' && distance <= 2) {
                        flag = true;
                        return;
                    }
                    else if (p[newX].charAt(newY) == 'O' && distance == 1) {
                        qu.add(new int[] {newX, newY});
                        visit[newX][newY] = true;
                    }
                }
            }
        }
        return;
    }
}