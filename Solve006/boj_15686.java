package Solve006;

import java.io.*;
import java.util.*;

public class boj_15686 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<point> chicken = new ArrayList<>();
    static boolean[] visit;
    static List<point> home = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    home.add(new point(i + 1, j + 1));
                }
                else if (x == 2) {
                    chicken.add(new point(i + 1, j + 1));
                }
            }
        }

        visit = new boolean[chicken.size()];
        solution(0, 0, m);
        System.out.println(result);
    }

    static void solution(int start, int cnt, int m) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        if (cnt == m) {
            for (int i = 0; i < home.size(); i++) {
                point hm = home.get(i);
                for (int j = 0; j < chicken.size(); j++) {
                    point ch = chicken.get(j);
                    if (visit[j]) {
                        int x = Math.abs(hm.x - ch.x);
                        int y = Math.abs(hm.y - ch.y);

                        if (min > x + y) {
                            min = x + y;
                        }
                    }
                }
                sum += min;
                min = Integer.MAX_VALUE;
            }
            if (result > sum) {
                result = sum;
            }
        }
        else {
            for (int i = start; i < chicken.size(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    solution(i, cnt + 1, m);
                    visit[i] = false;
                }
            }
        }
    }
}

class point {
    int x;
    int y;

    public point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}