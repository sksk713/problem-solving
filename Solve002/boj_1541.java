package Solve002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), "-");
        ArrayList<String> arr = new ArrayList<>();

        int i = 0;
        while(st.hasMoreTokens()){
            arr.add(st.nextToken());
            StringTokenizer str = new StringTokenizer(arr.get(i),"+");
            result = 0;
            while(str.hasMoreTokens()){
                result += Integer.parseInt(str.nextToken());
            }
            if(i == 0){
                answer.add(result);
            }
            else{
                answer.add(-(result));
            }
            i++;
        }
        int solution = 0;
        for(int x = 0; x < answer.size(); x++){
            solution += answer.get(x);
        }
        System.out.println(solution);

    }
}
