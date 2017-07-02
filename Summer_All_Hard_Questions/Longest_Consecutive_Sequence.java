package Summer_All_Hard_Questions;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i: nums) set.add(i);
        int max = 0;
        for(int i: nums){
        		if(!set.contains(i - 1)){
        			int count = 0;
            		int num = i;
        			while(set.contains(num)){
        				count ++;
        				num ++;
        			}
        			max = Math.max(max, count);
        		}
        }
        return max;
    }
}
