package Sum1;

import java.util.Arrays;
import java.util.HashMap;

public class Relative_Ranks {
	public String[] findRelativeRanks(int[] nums) {
		if(nums.length <= 0) return new String[0];
        String[] res = new String[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
        	map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int cnt = nums.length;
        for(int num: nums){
        	int index = map.get(num);
        	if(cnt == 3) res[index] = "Bronze Medal";
        	else if(cnt == 2) res[index] = "Silver Medal";
        	else if(cnt == 1) res[index] = "Gold Medal";
        	else res[index] = cnt+"";
        	cnt --;
        }
        return res;
    }
}
