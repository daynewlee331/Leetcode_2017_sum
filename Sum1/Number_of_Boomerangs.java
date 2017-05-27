package Sum1;

import java.util.HashMap;

public class Number_of_Boomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] p1: points){
        	for(int[] p2: points){
        		if(p1[0] == p2[0] && p1[1] == p2[1]) continue;
        		int d = dist(p1, p2);
        		if(!map.containsKey(d)) map.put(d, 1);
        		else map.put(d, map.get(d) + 1);
        	}
        	for(int distance: map.keySet()){
        		int size = map.get(distance);
        		res += size * (size - 1);
        	}
        	map.clear();
        }
        return res;
    }
	
	public int dist(int[] a, int[] b){
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}
}
