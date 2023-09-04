import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<List<String>> map = new ArrayList<>();
    static List<Position> teacherPositions = new ArrayList<>();
    static int obstacleCount = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            List<String> line = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                String input = st.nextToken();
                line.add(input);

                if (input.equals("T")) {
                    teacherPositions.add(new Position(i, j));
                }
            }
            map.add(line);
        }
        choiceObstacle();
        if (!flag) {
            System.out.println("NO");
        }
    }

    private static void choiceObstacle() {
        if (obstacleCount == 3) {
            if (isGoodPosition()) {
                System.out.println("YES");
                flag = true;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flag)
                    return;

                if (map.get(i).get(j).equals("X")) {
                    map.get(i).set(j, "O");
                    obstacleCount++;
                    choiceObstacle();
                    map.get(i).set(j, "X");
                    obstacleCount--;
                }
            }
        }
    }

    private static boolean isGoodPosition() {
        for (Position teacher : teacherPositions) {
            for (int teacherPosition = teacher.y; teacherPosition > -1 ; teacherPosition--) {
                if (map.get(teacher.x).get(teacherPosition).equals("O")) {
                    break;
                } else if (map.get(teacher.x).get(teacherPosition).equals("S")) {
                    return false;
                }
            }
            for (int teacherPosition = teacher.y; teacherPosition < n; teacherPosition++) {
                if (map.get(teacher.x).get(teacherPosition).equals("O")) {
                    break;
                } else if (map.get(teacher.x).get(teacherPosition).equals("S")) {
                    return false;
                }
            }
            for (int teacherPosition = teacher.x; teacherPosition > -1; teacherPosition--) {
                if (map.get(teacherPosition).get(teacher.y).equals("O")) {
                    break;
                } else if (map.get(teacherPosition).get(teacher.y).equals("S")) {
                    return false;
                }
            }
            for (int teacherPosition = teacher.x; teacherPosition < n; teacherPosition++) {
                if (map.get(teacherPosition).get(teacher.y).equals("O")) {
                    break;
                } else if (map.get(teacherPosition).get(teacher.y).equals("S")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
