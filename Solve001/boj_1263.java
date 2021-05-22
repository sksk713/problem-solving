package Solve001;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1263 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Time> arr = new ArrayList<Time>();
    static int time = 0;
        public static void main(String[] args) throws IOException {
            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            System.out.println(solution(n));
        }

        static int solution(int n){
            Collections.sort(arr, new Comparator<Time>() {
                @Override
                public int compare(Time o1, Time o2) {
                    return o1.si > o2.si ? 1 : -1;
                }
            });

            boolean flag = false;
            for(int i = 0; i <= arr.get(0).si; i++){
                int idx = 0;
                int sum = i;
                while(idx < n) {
                    sum += arr.get(idx).ti;
                    if (sum > arr.get(idx).si){
                        if(i == 0){
                            return -1;
                        }
                        flag = true;
                        break;
                    }
                    idx++;
                }
                if(flag == true){
                    break;
                }

                time = i;
            }
            return time;
        }
}

class Time{
    int ti;
    int si;

    public Time(int ti, int si){
        this.ti = ti;
        this.si = si;
    }
}
