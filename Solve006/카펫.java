package Solve006;

public class 카펫 {

    public static void main(String[] args) {
        System.out.println(solution(54, 24));
    }

    static int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];

        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i != 0) {
                continue;
            }

            int yellowCnt = yellow / i;
            int brownCnt = ((yellowCnt + 2) * 2) + (i * 2);

            if (brownCnt == brown) {
                answer[0] = yellowCnt + 2;
                answer[1] = i + 2;
                break;
            }
        }
        return answer;
    }
}
