package Solve008;

import java.util.*;
import java.io.*;

public class boj_11000 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Integer> possible = new PriorityQueue<>();
    static PriorityQueue<Classes> pq = new PriorityQueue<>(new Comparator<Classes>() {
        @Override
        public int compare(Classes o1, Classes o2) {
            if (o1.x > o2.x)
                return 1;
            else if (o1.x < o2.x)
                return -1;
            else if (o1.x == o2.x)
            {
                if (o2.y > o2.y)
                    return 1;
                else if (o2.y > o2.y)
                    return -1;
            }
                return 0;
        }
    });

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Classes(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        possible.add(0);
        boolean flag = false;
        while (!pq.isEmpty()) {
            Classes c = pq.poll();
            if (c.x >= possible.peek()) {
                possible.poll();
                possible.add(c.y);
                flag = true;
            }
            if (!flag)
                possible.add(c.y);
            flag = false;
        }
        System.out.println(possible.size());
    }
}

class Classes {
    int x;
    int y;

    public Classes (int x, int y) {
        this.x = x;
        this.y = y;
    }
}