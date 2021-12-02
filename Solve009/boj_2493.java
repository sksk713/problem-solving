package Solve009;

import java.io.*;
import java.util.*;

public class boj_2493 {
    static int[] tower;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tower = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while (st.hasMoreTokens())
            tower[i++] = Integer.parseInt(st.nextToken());
        shoot();
        System.out.println(result.toString().trim());
    }
    public static void shoot() {
        Stack<tower> t = new Stack<>();
        t.push(new tower(tower[0], 0));
        result.append("0 ");

        for (int i = 1; i < tower.length; i++) {
            while (true) {
                if (t.size() == 0) {
                    t.push(new tower(tower[i] ,i));
                    result.append("0 ");
                    break;
                }
                if (t.peek().height < tower[i])
                    t.pop();
                else {
                    result.append(t.peek().index + 1 + " ");
                    t.push(new tower(tower[i], i));
                    break;
                }
            }
        }
    }

    static class tower {
        int height;
        int index;

        public tower(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}