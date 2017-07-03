package Summer_All_Hard_Questions;

public class Trapping_Rain_Water {
	public int trap(int[] height) {
        if(height == null || height.length < 1) return 0;
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0, res = 0;
        while(i < j){
        		leftMax = Math.max(leftMax, height[i]);
        		rightMax = Math.max(rightMax, height[j]);
        		if(leftMax < rightMax){
        			res += leftMax - height[i ++];
        		}else{
        			res += rightMax - height[j --];
        		}
        }
        return res;
    }
}
