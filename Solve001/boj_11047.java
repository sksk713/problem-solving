package Solve001;

import java.util.Scanner;

public class boj_11047 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        
        int n = stdin.nextInt();
        int k = stdin.nextInt();
        int cnt = 0;
        
        int[] coin = new int[n];
        
        for(int i = 0; i < n; i++){
            coin[i] = stdin.nextInt();
        }
        
        for(int j = n - 1; j >= 0; j--){
            while(true){
                if(k >= coin[j]){
                    k -= coin[j];
                    cnt++;
                }
                else
                    break;
            }
        }
        System.out.print(cnt);
    }
}