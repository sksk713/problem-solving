package Solve008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Integer> minus = new PriorityQueue<>();
    static PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
    static int result = 0;
    static int maxVal = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int pos = Integer.parseInt(st.nextToken());
            if (pos > 0)
                plus.add(pos);
            else
                minus.add(pos);
        }
        if (plus.isEmpty())
            maxVal = (-minus.peek());
        else if (minus.isEmpty())
            maxVal = plus.peek();
        else if (plus.peek() > (-minus.peek()))
            maxVal = plus.peek();
        else
            maxVal = (-minus.peek());

        while (!minus.isEmpty()) {
            int mtemp = minus.poll();
            for (int i = 0; i < m - 1; i++) {
                if (minus.isEmpty())
                    break;
                minus.poll();
            }
            result += (-mtemp) * 2;
        }
        while (!plus.isEmpty()) {
            int ptemp = plus.poll();
            for (int i = 0; i < m - 1; i++) {
                if (plus.isEmpty())
                    break;
                plus.poll();
            }
            result += ptemp * 2;
        }
        result -= maxVal;
        System.out.println(result);
    }
}
