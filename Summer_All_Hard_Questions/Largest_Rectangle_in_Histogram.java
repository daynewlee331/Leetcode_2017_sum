package Summer_All_Hard_Questions;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
	public static void main(String[] args){
		Largest_Rectangle_in_Histogram sol = new Largest_Rectangle_in_Histogram();
		sol.largestRectangleArea(new int[]{2,1,5,6,2,3});
	}
	
	public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length < 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0, max = 0;
        while(i < heights.length) {
        	while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
        		int tmp = stack.pop();
        		int w = stack.isEmpty()? i: i - stack.peek() - 1;
        		int h = heights[tmp];
        		max = Math.max(max, w * h);
        	}
        	stack.push(i);
        	i ++;
        }
        while(!stack.isEmpty()){
        	int tmp = stack.pop();
    		int w = stack.isEmpty()? i: i - stack.peek() - 1;
    		int h = heights[tmp];
    		max = Math.max(max, w * h);
        }
        return max;
    }
}
