package Solve001;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.abs;

public class boj_1449{
    public static Scanner stdin = new Scanner(System.in);
    static int cnt;

    public static void main(String[] args){
        int n = stdin.nextInt();
        int l = stdin.nextInt();

        int[] hole = new int[n];
        for(int i = 0; i < n; i++){
            hole[i] = stdin.nextInt();
        }

        System.out.println(solution(hole, l));

    }
    static int solution(int[] hole, int l) {
        Arrays.sort(hole);
        int a = hole[0];
        cnt = hole.length;

        for(int i = 1; i < hole.length; i++){
            if((abs(a - hole[i]) + 1 <= l)){
                cnt--;
            }
            else {
                a = hole[i];
            }
        }
        return cnt;
    }
}