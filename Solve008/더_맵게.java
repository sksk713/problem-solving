package Solve008;

import java.util.*;

class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : scoville)
            pq.add(x);
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + (second * 2));
            answer++;
        }
        if (pq.peek() < K)
            return -1;
        return answer;
    }
}