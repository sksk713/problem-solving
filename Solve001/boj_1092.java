package Solve001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1092 {
    static ArrayList<Integer> box = new ArrayList<Integer>();
    static ArrayList<Integer> ship = new ArrayList<Integer>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int shipcnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < shipcnt; i++) {
            ship.add(Integer.parseInt(st.nextToken()));
        }
        int boxcnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < boxcnt; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(shipcnt));

    }

    static int solution(int s) {
        Collections.sort(box);
        Collections.sort(ship);
        Collections.reverse(box);
        Collections.reverse(ship);

        if (box.get(0) > ship.get(0)) {
            return -1;
        }
        while (!box.isEmpty()) {
            int ship_idx = 0;
            int box_idx = 0;
            while (ship_idx < s) {
                if (ship.get(ship_idx) >= box.get(box_idx)) {
                    box.remove(box_idx);
                    ship_idx++;
                }
                else if (ship.get(ship_idx) < box.get(box_idx)) {
                    box_idx++;
                }
                if(box_idx == box.size()){
                    break;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
