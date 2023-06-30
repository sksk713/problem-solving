import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> arr = new ArrayList<>();
    static int[] check = new int[11];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                Arrays.fill(check, -1);
                int[] score = new int[11];
                st = new StringTokenizer(br.readLine());

                int idx = 0;
                while (st.hasMoreTokens())
                    score[idx++] = Integer.parseInt(st.nextToken());
                arr.add(score);
            }
            dfs(0, 11);
            System.out.println(max);
            max = 0;
            arr.clear();
        }
    }

    static void dfs(int start, int end) {
        if (start == end) {
            int sum = 0;
            for (int val : check) {
                sum += val;
            }
            if (max < sum) {
                max = sum;
            }
            return ;
        }

        for (int i = 0; i < 11; i++) {
            if (check[i] == -1 && arr.get(start)[i] != 0) {
                check[i] = arr.get(start)[i];
                dfs(start + 1, end);
                check[i] = -1;
            }
        }
    }
}