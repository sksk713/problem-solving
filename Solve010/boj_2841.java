package Solve010;

import java.util.*;
import java.io.*;

public class boj_2841 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<PriorityQueue<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int i = 0; i < 7; i++) {
            list.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (list.get(a).size() == 0) {
                list.get(a).add(b);
                cnt++;
            }
            else if (list.get(a).peek() < b) {
                list.get(a).add(b);
                cnt++;
            }
            else if (list.get(a).peek() > b) {
                while (list.get(a).size() != 0) {
                    list.get(a).poll();
                    cnt++;
                    if (list.get(a).size() == 0 || list.get(a).peek() < b) {
                        list.get(a).add(b);
                        cnt++;
                        break;
                    }
                    if (list.get(a).peek() == b) {
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
