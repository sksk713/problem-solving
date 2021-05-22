package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int node;
    static int edge;
    static int[][] arr;
    static boolean[] check;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];


        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        for(int i = 1; i < node + 1; i++){
            if(!check[i]){
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void bfs(int node){
        Queue<Integer> qu = new LinkedList<>();
        check[node] = true;
        qu.add(node);

        while(!qu.isEmpty()){
            int x = qu.poll();
            for(int i = 1; i < arr.length; i++){
                if(!check[i] && arr[x][i] == 1){
                    qu.add(i);
                    check[i] = true;
                }
            }
        }
    }
}