package Sum1;

import java.util.Stack;

//http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
public class Largest_Rectangle_in_Histogram {
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length < 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        while(i < heights.length){
        		if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) stack.push(i ++);
        		else if(heights[stack.peek()] > heights[i]) {
        			int h = heights[stack.pop()];
        			int w = stack.isEmpty()? i : i - stack.peek() - 1;
        			max = Math.max(h * w, max);
        		}
        }
        while(!stack.isEmpty()){
        	int h = heights[stack.pop()];
			int w = stack.isEmpty()? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
        }
        return max;
    }
}
