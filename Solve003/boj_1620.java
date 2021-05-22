package Solve003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, String> mon;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        mon = new HashMap<>();
        for (int i = 0; i < x; i++){
            String monster = br.readLine();
            mon.put(monster, String.valueOf(i + 1));
            mon.put(String.valueOf(i + 1), monster);
        }
        solution(y);
    }

    public static void solution(int y) throws IOException{
        for(int i = 0; i < y; i++){
            System.out.println(mon.get(br.readLine()));
        }
    }

}
