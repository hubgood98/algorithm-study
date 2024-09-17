class Solution {
   public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];

        for (int i = 0; i < queries.length; i++) {
            int tmp = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = tmp;
        }
     
        int index=0;
        for(int a : arr)
        {
            answer[index++] = a;
        }
        return answer;
    }
}