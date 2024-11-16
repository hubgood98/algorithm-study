class Solution {
    public int solution(int n) {
        
         int count = 0;
        
        // k는 연속된 자연수의 개수 (1부터 n까지)
        for (int k = 1; k * (k + 1) / 2 <= n; k++) {
            if ((n - (k * (k - 1)) / 2) % k == 0) {
                count++;
            }
        }
        
        return count;
    }
}