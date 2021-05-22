package Solve001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class boj_1914 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger cnt = new BigInteger("2");
        cnt = cnt.pow(N);
        cnt = cnt.subtract(BigInteger.ONE);
        System.out.println(cnt);
        if(N <= 20) {
            hanoi_print(N, 1, 3);
        }
    }


    static void hanoi_print(int n, int x, int y){
        if(n > 1){
            hanoi_print(n-1, x, 6 - x - y);
        }
        System.out.println(x + " " + y);
        if(n > 1){
            hanoi_print(n-1, 6 - x - y, y);
        }
    }
}