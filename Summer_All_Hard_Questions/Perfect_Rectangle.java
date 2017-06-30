package Summer_All_Hard_Questions;

import java.util.HashSet;
import java.util.Set;

public class Perfect_Rectangle {
	public boolean isRectangleCover(int[][] rectangles) {
		int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;
		Set<String> set = new HashSet<String>();
		int area = 0;
        for(int[] arr: rectangles){
        		int a1 = arr[0] /*bottom-left*/, a2 = arr[2]/*top-right*/
        				, b1 = arr[1]/*bottom-left*/, b2 = arr[3]/*top-right*/;
        		x1 = Math.min(x1, a1);
        		x2 = Math.max(a2, x2);
        		y1 = Math.min(b1, y1);
        		y2 = Math.max(b2, y2);
        		String p1 = a1 + "-" + b1, p2 = a1 + "-" + b2, p3 = a2 + "-" + b1, p4 = a2 + "-" + b2;
        		area += (b2 - b1) * (a2 - a1);
        		if(!set.add(p1)) set.remove(p1);
        		if(!set.add(p2)) set.remove(p2);
        		if(!set.add(p3)) set.remove(p3);
        		if(!set.add(p4)) set.remove(p4);
        }
        if(set.size() != 4 || area != (y2 - y1) * (x2 - x1) 
        		|| !set.contains(x1 + "-" + y1) || !set.contains(x1 + "-" + y2) 
        		|| !set.contains(x2 + "-" + y2) || !set.contains(x2 + "-" + y1)) return false;
        return true;
    }
}
