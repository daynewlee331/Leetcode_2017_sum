package Sum1;

import java.util.Stack;

public class Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length < 1) return 0;
        int[] buffer = new int[matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix[0].length; i ++){
        		buffer[i] = matrix[0][i] - '0';
        }
        res = Math.max(res, largestRectangleArea(buffer));
        for(int i = 1; i < matrix.length; i ++){
        		for(int j = 0; j < matrix[i].length; j ++){
        			if(matrix[i][j] == '0') buffer[j] = 0;
        			else buffer[j] += matrix[i][j] - '0';;
        		}
        		res = Math.max(res, largestRectangleArea(buffer));
        }
        return res;
    }
	
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length < 1) return 0;
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		int i = 0;
		while(i < heights.length){
			int cur = heights[i];
			if(stack.isEmpty() || cur >= heights[stack.peek()]) stack.push(i ++);
			else{
				int h = heights[stack.pop()];
				int w = stack.isEmpty()? i: i - stack.peek() - 1;
				res = Math.max(res, h * w);
			}
		}
		while(!stack.isEmpty()){
			int h = heights[stack.pop()];
			int w = stack.isEmpty()? i: i - stack.peek() - 1;
			res = Math.max(res, h * w);
		}
		return res;
	}
}
