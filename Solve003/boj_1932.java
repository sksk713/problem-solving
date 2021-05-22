package Solve003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        arr = new ArrayList[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new ArrayList<>();
            while (st.hasMoreTokens()) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(solution(T));
    }

    static int solution(int T) {
        for (int i = 1; i < T; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    arr[i].set(j, arr[i - 1].get(j) + arr[i].get(j));
                }
                else if (j == i) {
                    arr[i].set(j, arr[i - 1].get(j - 1) + arr[i].get(j));
                }
                else {
                    arr[i].set(j, Math.max(arr[i - 1].get(j - 1), arr[i - 1].get(j)) + arr[i].get(j));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < T; i++) {
            if (max < arr[T - 1].get(i)) {
                max = arr[T - 1].get(i);
            }
        }
        return max;
    }
}
