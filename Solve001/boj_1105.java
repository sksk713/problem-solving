package Solve001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1105 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String x = st.nextToken();
        String y = st.nextToken();

        System.out.println(solution(x, y));
    }
    static int solution(String x, String y){
        if(x.length() == y.length()) {
            for (int i = 0; i < x.length(); i++) {
                if(x.charAt(i) == y.charAt(i)){
                    if(x.charAt(i) == '8'){
                        cnt++;
                    }
                }
                else
                    break;
            }
        }
        return cnt;
    }
}
