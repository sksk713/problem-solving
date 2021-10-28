package Solve008;

import java.util.*;

class Task {
    int loc;
    int prio;

    public Task(int loc, int prio) {
        this.loc = loc;
        this.prio = prio;
    }
}

class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int printCnt = 0;
        Queue<Task> qu = new LinkedList<>();
        boolean flag = false;

        for (int i = 0; i < priorities.length; i++) {
            qu.add(new Task(i, priorities[i]));
        }

        while (!qu.isEmpty()) {
            Task cur = qu.poll();
            flag = false;
            for (Task task : qu) {
                if (task.prio > cur.prio) {
                    flag = true;
                }
            }
            if (flag) {
                qu.add(cur);
            }
            else {
                printCnt++;
                if (cur.loc == location) {
                    answer = printCnt;
                    break;
                }

            }
        }
        return answer;
    }
}