package Summer_All_Hard_Questions;

import java.util.HashMap;

public class Subarray_Sum_Equals_K {
	public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i ++){
        		sum += nums[i];
        		int diff = sum - k;
        		if(map.containsKey(diff)) res += map.get(diff);
        		Integer cnt = map.get(sum);
        		if(cnt == null) map.put(sum, 1);
        		else map.put(sum, cnt + 1);
        }
        return res;
    }
}
