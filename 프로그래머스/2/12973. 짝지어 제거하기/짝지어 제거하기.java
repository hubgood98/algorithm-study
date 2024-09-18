import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c)
            {
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        answer = (stack.size() == 0)? 1 : 0;
        return answer;
    }
}