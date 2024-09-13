class Solution {
    public int[] solution(long n) {
       
          String str = ""+n;        
	      int[] answer = new int[str.length()];
	      
	      int cnt = 0;
	      while(n>0)
          {
            answer[cnt] = (int)(n%10);  //long형 n값 10을 나눈 나머지값
	        n/=10;
             cnt++;
          }
	        return answer;
    }
}