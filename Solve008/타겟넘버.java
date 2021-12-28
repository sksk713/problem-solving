class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        int[] operator = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            operator[i] = 1;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                operator[j] = 1;
            }
            dfs(0, i + 1, numbers, operator, target);
        }
        return answer;
    }
    
    public static void dfs(int start, int end, int[] numbers, int[] operator, int target) {
        if (start == end) {
            int result = 0;
            for (int i = 0; i < numbers.length; i++) {
                result += numbers[i] * operator[i];
            }
            if (result == target) {
                answer++;
            }
        }
        else {
            for (int i = start; i < numbers.length; i++) {
                operator[i] = -1;
                dfs(i + 1, end, numbers, operator, target);
                operator[i] = 1;
            }
        }
    }
}