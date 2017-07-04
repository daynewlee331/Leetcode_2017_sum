package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Sliding_Window_Maximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1 || k < 1) return new int[0];
        Deque<Integer> queue = new LinkedList<Integer>();
        List<Integer> buffer = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
				queue.removeLast();
			}
			queue.addLast(i);
			if (!queue.isEmpty() && i - queue.getFirst() + 1 > k) queue.removeFirst();
			if(i >= k - 1) buffer.add(nums[queue.getFirst()]);
		}
        int[] res = new int[buffer.size()];
        for(int i = 0; i < buffer.size(); i ++){
        		res[i] = buffer.get(i);
        }
        return res;
    }
}
