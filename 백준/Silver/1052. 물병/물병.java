import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0, index = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solve(n, k);
    }

    public static void solve(int n, int k) {
        String intToBinary = Integer.toBinaryString(n);
        int oneCount = Integer.bitCount(n);

        if (oneCount > k) {
            for (int i = 0; i < intToBinary.length(); i++) {
                if (k == 0) {
                    index = i;
                    break;
                }
                if (intToBinary.charAt(i) == '1') {
                    k--;
                }
            }
            String temp = intToBinary.substring(index);
            int tempToDecimal = Integer.parseInt(temp, 2);
            if (tempToDecimal != 0) {
                answer = (int)(Math.pow(2, intToBinary.length() - index) - tempToDecimal);
            }
        }
        System.out.println(answer);
    }
}