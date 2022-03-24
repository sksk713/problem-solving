package Solve013;

import java.util.*;
import java.io.*;

public class boj_1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Edge>[] edge;
    static int[] dist;
    static int n, m, start, end;

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static class Node {
        int idx, dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static void dijkstra() {
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.dist - o2.dist));

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.idx] != node.dist)
                continue;

            for (Edge e : edge[node.idx]) {
                if (dist[node.idx] + e.weight >= dist[e.to]) {
                    continue;
                }

                dist[e.to] = dist[node.idx] + e.weight;
                pq.add(new Node(e.to, dist[e.to]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edge = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++)
            edge[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edge[from].add(new Edge(to, weight));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(dist[end]);
    }
}
