package Sum1;

public class Max_Consecutive_Ones_Two {
	public int findMaxConsecutiveOnes(int[] nums) {
		if(nums == null || nums.length < 1) return 0;
        int total = 0, left = 0, right = 0;
        for(int num: nums){
        		if(num == 1) right ++;
        		else if(num == 0) {
        			left = right + 1;
        			right = 0;
        		}
        		total = Math.max(left + right, total);
        }
        return total;
    }
}
