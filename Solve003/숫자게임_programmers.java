package Solve003;

import java.util.*;

class 숫자게임_programmers {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int cnt = 0;
        int a_index = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            if(A[a_index] < B[i]){
                a_index++;
                answer++;
            }
        }
        return answer;
    }
}