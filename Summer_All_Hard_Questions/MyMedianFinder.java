package Summer_All_Hard_Questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyMedianFinder {
	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;
	
	/** initialize your data structure here. */
    public MyMedianFinder() {
    	minHeap = new PriorityQueue<Integer>();
    	maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
    	});
    }
    
    public void remove(int num){
    	if (num < findMedian()) {
	        maxHeap.remove(num);
	    }
	    else {
	        minHeap.remove(num);
	    }
    	if(maxHeap.size() - minHeap.size() >= 1) minHeap.offer(maxHeap.poll());
    	if(minHeap.size() - maxHeap.size() >= 2) maxHeap.offer(minHeap.poll());
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(maxHeap.size() - minHeap.size() >= 1) minHeap.offer(maxHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
        	return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        return (double) minHeap.peek();
    }
    
    public int getSize(){
    	return minHeap.size() + maxHeap.size();
    }
}
