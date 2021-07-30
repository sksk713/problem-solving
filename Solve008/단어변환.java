package Solve008;

public class 단어변환 {
    static boolean[] visit;
    static int cnt = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        visit = new boolean[words.length];

        System.out.println(solution(begin, target, words));
    }

    static int solution(String begin, String target, String[] words) {
        int flag = 0;
        for (String x : words) {
            if (x.equals(target)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            dfs(begin, target, words);
            return min;
        }
        else {
            return 0;
        }
    }

    static void dfs(String begin, String target, String[] words) {
        if (begin.equals(target)) {
            if (min > cnt) {
                min = cnt;
            }
//            System.out.println(cnt);
        }
        else {
            for (int i = 0; i < words.length; i++) {
                if (!visit[i] && check(begin, words[i])) {
                    visit[i] = true;
                    cnt++;
                    dfs(words[i], target, words);
                    cnt--;
                    visit[i] = false;
                }
            }
        }

    }

    static boolean check(String x, String y) {
        int diff = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
