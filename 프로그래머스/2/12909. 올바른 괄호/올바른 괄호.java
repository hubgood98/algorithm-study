import java.util.Stack;

class Solution {
    static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if(ch == '('){
                st.push(ch);
            }else if(ch == ')'){
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }
        
        return st.isEmpty();
    }
}