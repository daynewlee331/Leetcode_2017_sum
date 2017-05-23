package Sum1;

import java.util.Arrays;

public class Shortest_Unsorted_Continuous_Subarray {
	public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int start = -1, end = -1, len = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++){
        	max = Math.max(nums[i], max);
        	min = Math.min(nums[len - i - 1], min);
        	if(nums[i] < max) end = i;
        	if(nums[len - i - 1] > min) start = len - i - 1;
        }
        return start == -1? 0: end - start + 1;
    }
	
	
	public int findUnsortedSubarrayNaive(int[] nums) {
		if(nums == null || nums.length < 1) return 0;
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int i = 0, j = nums.length - 1;
        while(i <= j && tmp[i] == nums[i]) i ++;
        while(i <= j && tmp[j] == nums[j]) j --;
        return j - i + 1;
    }
}
