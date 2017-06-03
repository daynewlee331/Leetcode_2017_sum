package Sum1;

import java.util.Stack;

public class Longest_Absolute_File_Path {
	public int lengthLongestPath(String input) {
		if(input == null) return 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int res = 0;
		for(String line: input.split("\n")){
			int level = line.lastIndexOf("\t") + 1;
			while(level + 1 < stack.size()) stack.pop();
			int total = stack.peek() + line.length() - level + 1;
			stack.push(total);
			if(line.contains(".")) res = Math.max(res, total - 1);//doesn't need '/'
		}
		return res;
    }
}

