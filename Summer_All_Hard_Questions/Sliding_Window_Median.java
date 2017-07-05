package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;

public class Sliding_Window_Median {
	MyMedianFinder finder = new MyMedianFinder();
	public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1 || k < 1) return new double[0];
        double[] res = new double[nums.length - k + 1];
        int j = 0;
        List<Double> buff = new ArrayList<>();
        for(int i = 0; i <= nums.length; i ++){
        		if(finder.getSize() == k){
        			res[j ++] = finder.findMedian();
        			finder.remove(nums[i - k]);
        			if(i == nums.length) break;
        			finder.addNum(nums[i]);
        		}else if(finder.getSize() < k){
        			finder.addNum(nums[i]);
        		}
        }
        
        for(int i = 0; i < buff.size(); i ++) res[i] = buff.get(i);
        return res;
    }
}
