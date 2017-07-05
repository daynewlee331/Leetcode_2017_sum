package Summer_All_Hard_Questions;

import java.util.Stack;

public class Basic_Calculator {
	public int calculate(String s) {
        if(s == null || s.length() < 1) return 0;
        int sign = 1, i = 0, res = 0;
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        while(i < s.length()){
        		char c = s.charAt(i);
        		if(c == '+'){
        			i ++;
        			sign = 1;
        		}else if(c == '-') {
        			sign = -1;
        			i ++;
        		}else if(c == '('){
        			stack.push(sign * stack.peek());
        			sign = 1;
        			i ++;
        		}else if(c == ')'){
        			stack.pop();
        			sign = 1;
        			i ++;
        		}else{
        			char ch = s.charAt(i);
        			StringBuilder builder = new StringBuilder();
        			while(i < s.length() && ch - '0' >= 0 && ch - '0' <= 9) {
        				builder.append(ch); 
        				i ++;
        				if(i < s.length()) ch = s.charAt(i);
        			}
        			int num = Integer.parseInt(builder.toString());
        			res += sign * stack.peek() * num;
        		}
         }
        return res;
    }
}
