class Solution {
    public static int solution(int n) {

        int a = (int)Math.sqrt(n);
        return Math.pow(a,2)==n?1:2;
    }
}