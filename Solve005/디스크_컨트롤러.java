package Solve005;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {

    public static void main(String[] args) {
        int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43},{ 26, 1}};
        PriorityQueue<task> qu = new PriorityQueue<>();

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] < o2[0]) {
                    return -1;
                }
                else if (o1[0] == o2[0]) {
                    if (o1[1] < o2[1]) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        // delay는 task가 들어오고 대기하는 시간
        // timer는 현재 진행중인 시간
        // jobCnt는 전체 task 갯수
        // block은 현재 처리중인 task의 weight;
        // cnt는 각 task의 weigh합

        int delay = 0;
        int timer = 0;
        int jobCnt = jobs.length;
        int block = 0;

        int cnt = 0;

        // timer가 0부터 돌면서 시작 시간이 timer와 같으면 qu에 넣는다.
        while (true) {
            for (int i = 0; i < jobs.length; i++) {
                if (timer == jobs[i][0]) {
                    qu.offer(new task(jobs[i][1], jobs[i][0]));
                    jobCnt--;
                }
                else if (jobCnt == 0)
                    break;
            }

            // 현재 처리중인 task가 없는데 qu에 무언가가 있다면 실행
            while (block == 0 && !qu.isEmpty()) {
                task x = qu.poll();
                // 현재 timer보다 task시작시간이 작다면 대기시간이므로 delay에 더해줌
                if (timer > x.start) {
                    delay += (timer - x.start);
                }
                // cnt는 현재 처리중인 task의 weight를 더해주고 block에 해당 weight를 더해주면 block이 0이 되기전까진 다른 task 처리안됨
                cnt += x.weight;
                block = x.weight;
            }

            // 처리하는 것도 없고 job의 개수도 0이고 qu를 다 비우고 처리를 완료했다면
            if (block == 0 && jobCnt == 0 && qu.isEmpty()) {
                break;
            }

            // 순회마다 증가
            timer++;

            // block이 0이 아니면 task를 처리중이므로 하나씩 뺴줌줌
           if (block != 0) {
                block--;
            }

        }
        System.out.println(Math.round(cnt + delay) / jobs.length);
    }
}

class task implements Comparable<task> {
    int weight;
    int start;

    public task(int weight, int start) {
        this.weight = weight;
        this.start = start;
    }
    @Override
    public int compareTo(task task) {
        if (this.weight > task.weight)
            return 1;
        else
            return -1;
    }
}
