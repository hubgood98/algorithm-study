class Solution {
    public static int[] solution(int[] array) {

        int max = array[0],index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i; // 현재 인덱스를 저장
            }
        }
        
        int[] answer = {max, index};
        return answer;
    }
}