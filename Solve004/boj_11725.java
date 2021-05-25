package Solve004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1부터 탐색
public class boj_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] arr;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        result = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        solution(1);
    }

    static void solution(int start) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        result[start] = 0;
        visited[start] = true;

        while (!qu.isEmpty()) {
            int x = qu.poll();
            for (int i = 0; i < arr[x].size(); i++) {
                int node = arr[x].get(i);
                if (!visited[node]) {
                    result[node] = x;
                    qu.add(node);
                    visited[node] = true;
                }
            }

        }

        for (int i = 2; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
