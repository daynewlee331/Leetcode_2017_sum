package Sum1;

import java.util.HashMap;

public class Max_Points_on_a_Line {
	public static void main(String[] args){
		Max_Points_on_a_Line sol = new Max_Points_on_a_Line();
		sol.maxPoints(new Point[]{new Point(2, 3), new Point(94911151,94911150), new Point(94911152,94911151)});
	}
	
	public int maxPoints(Point[] points) {
		if(points == null || points.length < 1) return 0;
        int max = 0;
        for(int i = 0; i < points.length; i ++){
        		HashMap<String, Integer> map = new HashMap<>();
        		int same = 0;
        		String slp;
        		Point p1 = points[i];
        		for(int j = i + 1; j < points.length; j ++){
        			Point p2 = points[j];
        			if(p1.x == p2.x && p1.y == p2.y) {
        				same ++;
        				continue;
        			}
        			else if(p1.x == p2.x) {
        				slp = Math.PI+"";
        			}
        			else if(p1.y == p2.y) slp = "0";
        			else{
        				int y = p1.y - p2.y, x = p1.x - p2.x;
        				int g = gcd(y, x);
        				y /= g;
        				x /= g;
        				slp = y + "-" + x;
        			}
        			Integer cnt = map.get(slp);
    				if(cnt == null) map.put(slp, 1);
    				else map.put(slp, cnt + 1);
        		}
        		int localMax = 0;
        		for(String k: map.keySet()){
        			localMax = Math.max(localMax, map.get(k));
        		}
        		localMax += same + 1;
        		max = Math.max(localMax, max);
        }
        return max;
    }
	
	private int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}
