package Summer_All_Hard_Questions;

import java.util.HashMap;

public class Max_Points_on_a_Line {
	public int maxPoints(Point[] points) {
        if(points == null || points.length < 1) return 0;
        int max = 0;
        for(int i = 0; i < points.length; i ++){
        	int same = 1;
        	int localMax = 0;
        	HashMap<String, Integer> map = new HashMap<>();
        	Point p1 = points[i];
        	for(int j = i + 1; j < points.length; j ++){
        		Point p2 = points[j];
        		String slope = null;
        		if(p1.x == p2.x && p1.y == p2.y) {
        			same ++;
        			continue;
        		}
        		if(p1.x == p2.x) slope = "***";
        		else if(p1.y == p2.y) slope = "0";
        		else{
        			int x = p1.x - p2.x, y = p1.y - p2.y;
        			int g = GCD(x, y);
        			x /= g;
        			y /= g;
        			slope = x + "+" + y;
        		}
        		if(!map.containsKey(slope)) map.put(slope, 1);
        		else {
        			int num = map.get(slope);
        			map.put(slope, num + 1);
        		}
        		localMax = Math.max(map.get(slope), localMax);
        	}
        	localMax += same;
        	max = Math.max(localMax, max);
        }
        return max;
    }
	
	private int GCD(int a, int b){
		if(b == 0) return a;
		return GCD(b, a % b);
	}
}
