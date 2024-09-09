class Solution {
   public static int[] solution(int n, int k) {
        int max = n/k;
        int[] answer = new int[max];
        for(int i = 1; i*k <= n; i++) {
            answer[i-1] = i*k;
        }
        return answer;
    }
}