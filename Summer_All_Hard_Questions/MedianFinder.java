package Summer_All_Hard_Questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	public static void main(String[] args){
		MedianFinder sol = new MedianFinder();
		sol.addNum(1);
		sol.addNum(2);
		sol.findMedian();
		sol.addNum(3);
		sol.findMedian();
	}
	
	private PriorityQueue<Integer> minHeap = null;
	private PriorityQueue<Integer> maxHeap = null;
	
	/** initialize your data structure here. */
    public MedianFinder() {
    		minHeap = new PriorityQueue<>();
    		maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
    			@Override
    			public int compare(Integer o1, Integer o2) {
    				// TODO Auto-generated method stub
    				return o2 - o1;
    			}
    		});
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if(maxHeap.size() - minHeap.size() >= 1) minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        int x = minHeap.peek(), y = maxHeap.peek();
        return (x + y) / 1.0;
    }
}
