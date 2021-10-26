package Solve008;

import java.util.*;

class 기능개발 {

    public static void main(String[] args) {
        int[] progresses = {96, 94};
        int[] speeds = {3, 3};

        solution(progresses, speeds);
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ret = new ArrayList<>();
        int cnt = 1;
        for (int i = 0; i < progresses.length; i++)
            ret.add((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < ret.size() - 1; i++)
        {
            if (ret.get(i) >= ret.get(i + 1)) {
                cnt++;
                if (i == ret.size() - 2)
                    answer.add(cnt);
            }
            else {
                answer.add(cnt);
                cnt = 1;
                if (i == ret.size() - 2) {
                    answer.add(cnt);
                }
            }
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++)
            result[i] = answer.get(i);
        return result;
    }
}