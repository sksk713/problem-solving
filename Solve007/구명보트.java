package Solve007;

import java.util.*;

class 구명보트 {
    public int solution(int[] people, int limit) {
        boolean[] visit = new boolean[people.length];
        int cnt = 0;
        int x = limit;

        Arrays.sort(people);
        int flag = 0;

        for (int i = 0; i < people.length; i++) {
            if (visit[i]) {
                continue;
            }
            limit = x;
            flag = 0;
            for (int j = people.length - 1; j > i; j--) {
                if (visit[j]) {
                    continue;
                }
                if (limit - people[j] < 40) {
                    visit[j] = true;
                    cnt++;
                    continue;
                }
                if (limit >= (people[i] + people[j])) {
                    visit[i] = true;
                    visit[j] = true;
                    flag = 1;
                    cnt++;
                    break;
                }
            }
            if (flag != 1) {
                visit[i] = true;
                cnt++;
            }
        }
        return cnt;
    }
}