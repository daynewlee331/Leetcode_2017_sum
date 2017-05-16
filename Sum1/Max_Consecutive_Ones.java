package Sum1;

public class Max_Consecutive_Ones {
	public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int res = 0;
        Integer count = 0;
        for(int num: nums){
        		if(num == 1){
        			count ++;
        			res = Math.max(count, res);
        		}else{
        			count = 0;
        		}
        }
        return res;
    }
}
