import java.util.ArrayList;
class Solution {
    public static int[] solution(int[] num_list) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<num_list.length;i++)
        {
            list.add(num_list[i]);
        }

        if(num_list[num_list.length-1]>num_list[num_list.length-2]){
            list.add(num_list[num_list.length-1]-num_list[num_list.length-2]);
        }else{
            list.add(num_list[num_list.length-1]*2);

        }
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }

}