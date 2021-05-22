package Solve001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_1174 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int num = 0; num < 10; num++) {
            solution(num, 1, list);
        }
        Collections.sort(list);

        if(T > 1023){
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(T - 1));
        }
    }

    static ArrayList solution(long num, int digit, ArrayList list){
        if(digit > 10){
            return list;
        }
        list.add(num);
        for(int i = 0; i < 10; i++){
            if(num % 10 > i){
                solution(num * 10 + i, digit + 1, list);
            }
        }
        return list;
    }
}
