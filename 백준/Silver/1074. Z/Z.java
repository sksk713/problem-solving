import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, r, c, result = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        solve();
    }

    static void solve() {
        while (n != 0) {
            int halfOfSideLength = (int)Math.pow(2, n - 1);
            if (n > 1) {
                if (halfOfSideLength > r && halfOfSideLength <= c) {
                    result += (int)Math.pow(halfOfSideLength, 2);
                    c -= halfOfSideLength;
                }
                else if (halfOfSideLength <= r && halfOfSideLength > c) {
                    result += (int)Math.pow(halfOfSideLength, 2) * 2;
                    r -= halfOfSideLength;
                }
                else if (halfOfSideLength <= r && halfOfSideLength <= c) {
                    result += (int)Math.pow(halfOfSideLength, 2) * 3;
                    r -= halfOfSideLength;
                    c -= halfOfSideLength;
                }
            }
            else if (n == 1) {
                if (r == 0 && c == 1) {
                    result += 1;
                }
                else if (r == 1 && c == 0) {
                    result += 2;
                }
                else if (r == 1 && c == 1) {
                    result += 3;
                }
            }
            n--;
        }
        System.out.println(result);
    }
}
