package Solve006;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {

    static int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> minQu = new PriorityQueue<>(); // 최소값 출력할 큐
        PriorityQueue<Integer> maxQu = new PriorityQueue<>(Collections.reverseOrder()); // 최대값 출력할 큐
        int cnt = 0; // 내부에 데이터가 남아있는지 확인

        StringTokenizer st;

        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);

            // I가 들어오면 두 개의 큐 모두에 추가 시킴
            if (st.nextToken().charAt(0) == 'I') {
                int n = Integer.parseInt(st.nextToken());
                minQu.offer(n);
                maxQu.offer(n);
                cnt++;
            }
            else {
                int n = Integer.parseInt(st.nextToken());
                // D 1이면 최대값 큐에서 뺸다.
                if (n == 1) {
                    maxQu.poll();
                    cnt--;
                }
                // D -1이면 최소값 큐에서 뺀다.
                else {
                    minQu.poll();
                    cnt--;
                }
                // cnt가 0이면 내부에 데이터가 없다는 뜻이므로 둘다 비운다.
                if (cnt == 0) {
                    maxQu.clear();
                    minQu.clear();
                }
            }

        }

        answer = new int[2];
        if (cnt <= 0) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        else {
            int max = maxQu.poll();
            int min = minQu.poll();
            answer[0] = max;
            answer[1] = min;
            return answer;
        }

    }
    public static void main(String[] args) {
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};

        System.out.println(solution(operations)[0] + " " + solution(operations)[1]);
    }


}
