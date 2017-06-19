package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 1) return res;
		getPerm(nums, res, new ArrayList<Integer>());
		return res;
    }
	
	public void getPerm(int[] nums, List<List<Integer>> res, List<Integer> cur){
		if(cur.size() == nums.length){
			res.add(cur);
			return;
		}
		for(int i = 0; i < nums.length; i ++){
			List<Integer> buf = new ArrayList<>(cur);
			if(!buf.contains(nums[i])) {
				buf.add(nums[i]);
				getPerm(nums, res, buf);
			}
		}
	}
}
