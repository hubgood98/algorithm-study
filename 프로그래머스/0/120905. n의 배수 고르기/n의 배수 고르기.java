import java.util.ArrayList;
public class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int val : numlist) {
            if (val % n == 0) {
                list.add(val);
            }
        }

     
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}