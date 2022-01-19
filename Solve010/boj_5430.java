package Solve010;

import java.io.*;
import java.util.*;

public class boj_5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            boolean isReverse = false;
            boolean isError = false;
            Deque<Integer> qu = new ArrayDeque<>();
            String cmd = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String arr = br.readLine().replace("[", "").replace("]", "").replace(","," ");
            st = new StringTokenizer(arr);

            while (st.hasMoreTokens()) {
                qu.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < cmd.length(); j++) {
                if (cmd.charAt(j) == 'R') {
                    if (isReverse)
                        isReverse = false;
                    else
                        isReverse = true;
                }
                else {
                    if (qu.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if (isReverse)
                        qu.removeLast();
                    else
                        qu.removeFirst();
                }
            }
            if (isError) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (isReverse) {
                while (!qu.isEmpty()) {
                    sb.append(qu.removeLast());
                    if (qu.size() != 0)
                        sb.append(",");
                }
            }
            else {
                while (!qu.isEmpty()) {
                    sb.append(qu.removeFirst());
                    if (qu.size() != 0)
                        sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
