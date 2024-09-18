import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
       static public int[] solution(int l, int r) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = l ; i<=r ; i++)
        {
            if(containsOnlyZeroAndFive(i)){
                result.add(i);
            }

        }

        if(result.isEmpty())
        {
            return new int[]{-1};
        }

        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static boolean containsOnlyZeroAndFive(int num) {
        if (num == 0) return true;

        while (num > 0) {
            int digit = num % 10;
            if (digit != 0 && digit != 5) {
                return false;  // 0과 5가 아닌 숫자가 있으면 false
            }
            num /= 10;  // 마지막 자릿수를 제거
        }
        return true;
    }
}