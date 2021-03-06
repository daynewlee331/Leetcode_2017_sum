package Summer_All_Hard_Questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;
	
	/** initialize your data structure here. */
    public MedianFinder() {
    	minHeap = new PriorityQueue<Integer>();
    	maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
    	});
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(maxHeap.size() - minHeap.size() >= 1) minHeap.offer(maxHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
        	int x = maxHeap.peek(), y = minHeap.peek();
        	return (x + y) / 2.0;
        }
        return minHeap.peek();
    }
}
