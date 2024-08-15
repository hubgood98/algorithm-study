package src.main.java.org.study;

import java.util.ArrayList;
import java.util.Arrays;

public class test2 {
    public static int[] solution(int[] arr, int[] delete_list) {

        ArrayList<Integer> arr_list = new ArrayList<>();

        for(int a : arr)
        {
            arr_list.add(a);
        }


        for(int b: delete_list)
        {
           arr_list.remove(Integer.valueOf(b));
        }

        int[] answer = new int[arr_list.size()];
        for (int i = 0; i < arr_list.size(); i++)
        {
            answer[i] = arr_list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] delete_list = {2, 4};

        System.out.println(Arrays.toString(solution(arr, delete_list)));
    }
}
