package mont;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int val : numlist)
        {
            if(val % n == 0)
                list.add(val);
        }


        return list.toArray().;
    }
}