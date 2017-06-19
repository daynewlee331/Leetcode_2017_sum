package Sum1;

public class Maximum_Subarray {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length < 1) return 0;
		int min = 0, res = nums[0], sum = 0;
		for(int i = 0; i < nums.length; i ++){
			sum += nums[i];
			if(sum - min > res) res = sum - min;
			if(sum < min) min = sum;
		}
		return res;
	}
}
