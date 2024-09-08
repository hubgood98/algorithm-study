class Solution {
    public int[] solution(String myString) {
        
        String[] words = myString.split("x",-1);
        int[] answer = new int[words.length];
        for(int i =0;i<words.length;i++){
            answer[i]= words[i].length();
        }
        
        return answer;
    }
}