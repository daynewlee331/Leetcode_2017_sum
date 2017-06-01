package Sum1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Sliding_Window_Maximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length < 1 || k < 1) return new int[0];
        Deque<Integer> queue = new LinkedList<Integer>();
        List<Integer> buff = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i ++){
        	while(queue.size() > 0 && nums[queue.getLast()] < nums[i]){
        		queue.removeLast();
        	}
        	queue.addLast(i);
        	if(i - queue.getFirst() + 1 > k) queue.removeFirst();
        	if(i >= k - 1) buff.add(nums[queue.getFirst()]);
        }
        //buff.add(window.getFirst());
        int[] res = new int[buff.size()];
        for(int j = 0; j < buff.size(); j ++){
        	res[j] = buff.get(j);
        }
        return res;
    }
}
