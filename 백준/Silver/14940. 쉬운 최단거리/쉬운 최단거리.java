import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static List<List<Integer>> map = new ArrayList<>();
    static Queue<Point> qu = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> raw = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                raw.add(Integer.parseInt(st.nextToken()));
            }
            map.add(raw);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(i).get(j) == 2) {
                    map.get(i).set(j, 0);
                    qu.add(new Point(i, j));
                }
                else if (map.get(i).get(j) == 1) {
                    map.get(i).set(j, -1);
                }
                else if (map.get(i).get(j) == 0) {
                    map.get(i).set(j, -2);
                }
            }
        }
        bfs();
    }

    static int[] dx = {-1 , 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void bfs() {
        while (!qu.isEmpty()) {
            Point point = qu.poll();

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                if (map.get(newX).get(newY) >= 0 || map.get(newX).get(newY) == -2) {
                    continue;
                }

                map.get(newX).set(newY, map.get(point.x).get(point.y) + 1);
                qu.offer(new Point(newX, newY));
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(i).get(j) == -2) {
                    sb.append(0);
                }
                else {
                    sb.append(map.get(i).get(j));
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
