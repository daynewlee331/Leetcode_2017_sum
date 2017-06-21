package Sum1;

import java.util.Stack;

public class Remove_Duplicate_Letters {
	public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) count[c - 'a'] ++;
        for(char c: s.toCharArray()) {
        		count[c - 'a'] --;
        		if(visited[c - 'a']) continue;
        		while(!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0){
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
