package Solve006;

import java.util.*;

public class 소수_찾기 {
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> result = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "011";

        solution(numbers);

    }

    static int solution(String numbers) {
        int answer = 0;

        visit = new boolean[numbers.length()];

        for (int i = 1; i < numbers.length() + 1; i++) {
            permutation(numbers, 0, i);
        }

        answer = result.size();
        return answer;
    }

    static void permutation(String numbers, int lengCnt, int end) {
        if (lengCnt == end) {
            if (isPrime(sb.toString())) {
                result.add(Integer.parseInt(sb.toString()));
            }
        }
        else {
            for (int i = 0; i < numbers.length(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    sb.append(numbers.charAt(i));
                    permutation(numbers, lengCnt + 1, end);
                    sb.deleteCharAt(sb.length() - 1);
                    visit[i] = false;
                }
            }
        }
    }
    static boolean isPrime(String sb) {
        int n = Integer.parseInt(sb);

        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
