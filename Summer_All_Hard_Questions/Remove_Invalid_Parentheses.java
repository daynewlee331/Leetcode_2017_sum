package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Remove_Invalid_Parentheses {
	public static void main(String[] args){
		Remove_Invalid_Parentheses sol = new Remove_Invalid_Parentheses();
		sol.removeInvalidParentheses("(");
	}
	
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		visited.add(s);
		queue.add(s);
		boolean isFound = false;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i ++){
				String cur = queue.poll();
				if(isValid(cur)) {
					res.add(cur);
					isFound = true;
				}
				if(isFound) continue;
				for(int j = 0; j < cur.length(); j ++){
					if(cur.charAt(j) != '(' && cur.charAt(j) != ')') continue;
					String neighbor = cur.substring(0, j) + cur.substring(j + 1);
					if(!visited.contains(neighbor)){
						queue.offer(neighbor);
						visited.add(neighbor);
					}
				}
			}
			if(isFound) break;
		}
		return res;
    }
	
	private boolean isValid(String s){
		int count = 0;
		char[] chars = s.toCharArray();
		for(char c: chars){
			if(c == '(') count ++;
			else if(c == ')') count --;
			if(count < 0) return false;
		}
		return count == 0;
	}
}
