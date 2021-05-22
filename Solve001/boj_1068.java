package Solve001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1068 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] tree;
    static boolean[] isvisited;
    static int leaf_cnt = 0;
    static int root = 0;
    static int delete_idx = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        isvisited = new boolean[n];
        tree = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<Integer>();
            isvisited[i] = false;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            int parent = Integer.parseInt(st.nextToken());

            if(parent != -1) {
                tree[i].add(parent);
                tree[parent].add(i);
            }
            else root = i;
        }
        delete_idx = Integer.parseInt(br.readLine());

        if(delete_idx == root){
            System.out.println(0);
        }
        else{
            DFS(root);
            System.out.println(leaf_cnt);
        }
    }

    static void DFS(int node){
        isvisited[node] = true;
        boolean haschild = false;
        for(int i = 0; i < tree[node].size(); i++){
            if(tree[node].get(i) != delete_idx && !isvisited[tree[node].get(i)]) {
                haschild = true;
                DFS(tree[node].get(i));
            }
        }
        if(!haschild){
            leaf_cnt++;
        }
    }


}
