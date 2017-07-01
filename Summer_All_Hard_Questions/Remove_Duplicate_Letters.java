package Summer_All_Hard_Questions;

import java.util.Stack;

public class Remove_Duplicate_Letters {
	public static void main(String[] args){
		Remove_Duplicate_Letters sol = new Remove_Duplicate_Letters();
		sol.removeDuplicateLetters("bcabc");
	}
	
	public String removeDuplicateLetters(String s) {
        if(s == null || s.isEmpty()) return s;
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i ++) count[chars[i] - 'a'] ++;
        for(int i = 0; i < chars.length; i ++){
        		char c = chars[i];
        		count[c - 'a'] --;
        		if(visited[c - 'a']) continue;
        		while(!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
        			char tmp = stack.pop();
        			visited[tmp - 'a'] = false;
        		}
        		stack.push(c);
        		visited[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) builder.append(stack.pop());
        return builder.reverse().toString();
    }
}
