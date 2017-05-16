package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Disappeared_Nums {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length < 1) return new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i ++){
        		int index = Math.abs(nums[i]) - 1;
        		if(nums[index] > 0) nums[index] = -nums[index];
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i ++){
        		if(nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}
