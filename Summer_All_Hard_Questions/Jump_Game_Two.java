package Summer_All_Hard_Questions;


public class Jump_Game_Two {
	public int jump(int[] nums) {
		if(nums == null || nums.length <= 1) return 0;
		int max = 0, step = 0, i = 0;
        while(max >= i){
        		int localMax = 0;
        		for(; i <= max; i ++){
        			localMax = Math.max(localMax, i + nums[i]);
        			if(localMax >= nums.length - 1) return step + 1;
        		}
        		max = localMax;
        		step ++;
        }
        return 0;
    }
}
