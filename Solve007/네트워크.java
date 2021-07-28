package Solve007;

public class 네트워크 {
    static int cnt = 0;
    static boolean[] visit;

    public int solution(int n, int[][] computers) {
        visit = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            if (visit[i]) {
                continue;
            }
            for (int j = i; j < computers[0].length; j++) {
                if (computers[i][j] == 1 && i != j) {
                    dfs(j, computers[0].length, computers);
                }
            }
            cnt++;
        }
        return cnt;
    }

    static void dfs(int start, int size, int[][] x) {
        visit[start] = true;
        for (int i = 1; i < size; i++) {
            if (visit[i]) {
                continue;
            }
            if (x[start][i] == 1 && i != start) {
                dfs(i, x[0].length, x);
            }
        }
        return;
    }
}