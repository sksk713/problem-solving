package Solve001;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1946 {
    static ArrayList<point> arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new ArrayList<point>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr.add(new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            System.out.println(solution(n));
        }
    }
    static int solution(int n){
        Collections.sort(arr, new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                return o1.x > o2.x ? 1 : -1;
            }
        });
        int cnt = arr.size();
        int min = arr.get(0).y;
        for(int i = 1; i < n; i++){
            if(min < arr.get(i).y){
                cnt--;
            }
            else
                min = arr.get(i).y;
        }

        return cnt;
    }
}
class point{
    int x;
    int y;

    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
}