package Solve004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_2407 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger up = BigInteger.ONE;
        BigInteger down = BigInteger.ONE;
        BigInteger div = BigInteger.valueOf(m);

        for (int i = n; i > n - m; i--) {
            up = up.multiply(BigInteger.valueOf(i));
            down = down.multiply(div);
            div = div.subtract(BigInteger.ONE);
        }

        BigInteger result = up.divide(down);
        System.out.println(result);
    }
}
