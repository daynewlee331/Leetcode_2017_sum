package Sum1;

import java.util.HashMap;

public class Subarray_Sum_Equals_K {
	public static void main(String[] args){
		Subarray_Sum_Equals_K sol = new Subarray_Sum_Equals_K();
		sol.subarraySum(new int[]{1,1,1}, 2);
	}
	
	public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for(int i = 0; i < nums.length; i ++){
        		int diff = sum - k;
        		if(map.containsKey(diff)) res += map.get(diff);
        		sum += nums[i];
        		Integer cnt = map.get(sum);
        		if(cnt == null) map.put(sum, 1);
        		else map.put(sum, cnt + 1);
        }
        return res;
    }
}
