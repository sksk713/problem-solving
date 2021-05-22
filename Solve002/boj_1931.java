package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<time> arr = new ArrayList<>();
    static int cnt = 0;
    static int pivot;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr.add(new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(solution(n));
    }

    static int solution(int n){
        Collections.sort(arr, new Comparator<time>() {
            @Override
            public int compare(time o1, time o2) {
                if(o1.y == o2.y){
                    return o1.x > o2.x ? 1 : -1;
                }

                return o1.y > o2.y ? 1 : -1;
            }
        });

        pivot = 0;

        for(int i = 0; i < n; i++){
            if(pivot <= arr.get(i).x){
                pivot = arr.get(i).y;
                cnt++;
            }
        }
        return cnt;
    }

    static class time{
        int x;
        int y;

        public time(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
