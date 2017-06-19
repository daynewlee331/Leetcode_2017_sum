package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Missing_Ranges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		if(nums == null || nums.length < 1) {
			if(lower == upper) res.add(lower + "");
			else if(lower <= upper) res.add(lower + "->" + upper);
			return res;
		}
		int i = 0;
		if(lower < nums[0]){
			int tmp = nums[0] - lower;
			String s = tmp == 1? lower+"" : lower + "->" + (nums[0] - 1);
			res.add(s);
			//i ++;
		}
		StringBuilder buff = new StringBuilder();
		for(; i < nums.length; i ++){
			if(i + 1 < nums.length && (long) nums[i + 1] == (long) nums[i] + 1) continue;
			if(i + 1 < nums.length && (long) nums[i + 1] > (long) nums[i] + 1){
				if((long) nums[i] + 1 == (long) nums[i + 1] - 1){
					buff.append(nums[i] + 1);
				}else{
					buff.append(nums[i] + 1);
					buff.append("->");
					buff.append(nums[i + 1] - 1);
				}
				res.add(buff.toString());
				buff.setLength(0);
				continue;
			}
		}
		buff.setLength(0);
		if(nums[nums.length - 1] < upper) {
			if((long) nums[nums.length - 1] + 1 == upper){
				buff.append(upper);
			}else{
				buff.append(nums[nums.length - 1] + 1);
				buff.append("->");
				buff.append(upper);
			}
			res.add(buff.toString());
		}
		return res;
    }
}
