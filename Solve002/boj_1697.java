package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q = new LinkedList<Integer>();
    static int[] visit = new int[100001];
    static int answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        BFS(x, y);
        System.out.println(answer);
    }

    static void BFS(int x, int y) {
        q.add(x);
        visit[x] = 0;

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == y) {
                break;
            }
            if (num - 1 >= 0 && visit[num - 1] == 0) {
                visit[num - 1] = visit[num] + 1;
                q.add(num - 1);
            }
            if (num + 1 < 100000 && visit[num + 1] == 0) {
                visit[num + 1] = visit[num] + 1;
                q.add(num + 1);
            }
            if (num * 2 <= 100000 && visit[num * 2] == 0) {
                visit[num * 2] = visit[num] + 1;
                q.add(num * 2);
            }
        }
        answer = visit[y];
    }
}
