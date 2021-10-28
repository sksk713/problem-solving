package Solve008;

import java.util.*;

class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ret = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < progresses.length; i++)
            ret.add((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        for (int i = 0; i < ret.size(); i++) {
            if (ret.get(i) > max) {
                max = ret.get(i);
                answer.add(1);
            }
            else {
                answer.set(answer.size() - 1, answer.get(answer.size() - 1) + 1);
            }
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++)
            result[i] = answer.get(i);
        return result;
    }
}