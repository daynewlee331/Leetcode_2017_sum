package Sum1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue_Reconstruction_by_Height {
	public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length < 1) return people;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] != o2[0]) return o2[0] - o1[0];
				else return o1[1] - o2[1];
			}
        });
        
        for(int[] person: people) pq.offer(person);
        ArrayList<int[]> ll = new ArrayList<>();
        while(!pq.isEmpty()) {
        		int[] person = pq.poll();
        		ll.add(person[1], person);
        	}
        int[][] res = new int[people.length][];
        for(int i = 0; i < ll.size(); i ++) res[i] = ll.get(i);
        return res;
    }
}	
