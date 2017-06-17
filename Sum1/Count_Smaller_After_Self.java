package Sum1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count_Smaller_After_Self {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> sorted = new ArrayList<Integer>();
		Integer[] res = new Integer[nums.length];
		for(int i = nums.length - 1; i >= 0; i --){
			int pos = findSpot(sorted, nums[i]);
			res[i] = pos;
			sorted.add(pos, nums[i]);
		}
        return Arrays.asList(res);
    }
	
	public int findSpot(List<Integer> sorted, int target){
		if(sorted.size() == 0) return 0;
		int i = 0, j = sorted.size() - 1;
		if(target > sorted.get(j)) return j + 1;
		if(target <= sorted.get(i)) return 0;
		while(i <= j){
			int mid = (j - i) / 2 + i;
			if(sorted.get(mid) < target) {
				i = mid + 1;
			}else j = mid - 1;
		}
		return i;
	}
}
