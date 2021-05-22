package Solve004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<node>[] arr;
    static int[] result;
    static boolean[] visited;
    static PriorityQueue<node> qu = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        arr = new ArrayList[v + 1];
        result = new int[v + 1];
        visited = new boolean[v + 1];

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < v + 1; i++) {
            arr[i] = new ArrayList<node>();
            result[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())].add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        solution(v, e, start);
    }

    static void solution(int v, int e, int start) {
        qu.add(new node(start, 0));
        result[start] = 0;
        
        while (!qu.isEmpty()) {
            int current = qu.poll().node;
            if (!visited[current]) {
                visited[current] = true;
            }
            else
                continue;
            for (int i = 0; i < arr[current].size(); i++) {
                if (result[arr[current].get(i).node] > result[current] + arr[current].get(i).weight) {
                    result[arr[current].get(i).node] = result[current] + arr[current].get(i).weight;
                    qu.add(new node(arr[current].get(i).node, result[arr[current].get(i).node]));
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else
                System.out.println(result[i]);
        }
    }
}

class node implements Comparable<node> {
    int node;
    int weight;

    public node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int compareTo(node n) {
        return weight - n.weight;
    }
}