package Sum1;

import java.util.Stack;

public class Longest_Valid_Parentheses {
	public static void main(String[] args){
		Longest_Valid_Parentheses sol = new Longest_Valid_Parentheses();
		sol.longestValidParentheses("())");
	}
	
	public int longestValidParentheses(String s) {
        if(s == null || s.length() < 1) return 0;
        Stack<Integer> stack = new Stack<>();
        s += "X";
        int res = 0;
        for(int i = 0; i < s.length(); i ++){
        		char c = s.charAt(i);
        		if(c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
        		else{
        			if(stack.isEmpty()) res = Math.max(res, i);
        			else{
        				int index = stack.peek();
        				int len = i - index - 1;
        				res = Math.max(len, res);
        			}
        			stack.push(i);
        		}
        }
        return stack.isEmpty()? s.length(): res;
    }
}
