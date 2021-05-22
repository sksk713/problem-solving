package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[] check;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        check = new boolean[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }

        System.out.println(solution());
    }

    static int solution(){
        Queue<Integer> qu = new LinkedList<>();
        check[1] = true;
        qu.add(1);

        while(!qu.isEmpty()){
            int x = qu.poll();

            for(int i = 1; i < map.length; i++){
                if(map[x][i] == 1 && !check[i]){
                    check[i] = true;
                    qu.add(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
