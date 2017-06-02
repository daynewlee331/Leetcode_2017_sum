package Sum1;

import java.util.Arrays;

public class Three_Sum_Smaller {
	public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i ++){
        		int j = i + 1;
        		int k = nums.length - 1;
        		while(j < k){
        			int sum = nums[i] + nums[j] + nums[k];
        			if(sum < target){
        				res += k - j;
        				j ++;
        			}else{
        				k --;
        			}
        		}
        }
        return res;
    }
}
