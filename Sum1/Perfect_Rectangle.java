package Sum1;

import java.util.HashSet;
import java.util.Set;

public class Perfect_Rectangle {
	/**
	 * the large rectangle area should be equal to the sum of small rectangles
	 * count of all the points should be even, and that of all the four corner points should be one
	 * - 最左下 最左上 最右下 最右上 的四个点只出现过一次,其他肯定是成对出现的(保证完全覆盖)
	 * - 上面四个点围成的面积,正好等于所有子矩形的面积之和(保证不重复)
	 * **/
	public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles == null || rectangles.length < 1) return false;
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE, area = 0;
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < rectangles.length; i ++){
        		x1 = Math.min(x1, rectangles[i][0]);
        		y1 = Math.min(y1, rectangles[i][1]);
        		x2 = Math.max(x2, rectangles[i][2]);
        		y2 = Math.max(y2, rectangles[i][3]);
        		area += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
        		String p1 = rectangles[i][0] + "+" + rectangles[i][1], p2 = rectangles[i][2] + "+" + rectangles[i][3];
        		String p3 = rectangles[i][0] + "+" + rectangles[i][3], p4 = rectangles[i][2] + "+" + rectangles[i][1];
        		if(!set.add(p1)) set.remove(p1);
        		if(!set.add(p2)) set.remove(p2);
        		if(!set.add(p3)) set.remove(p3);
        		if(!set.add(p4)) set.remove(p4);
        		
        }
        if(set.size() != 4 || !set.contains(x1 + "+" + y1) || !set.contains(x2 + "+" + y2) || !set.contains(x2 + "+" + y1) || !set.contains(x1 + "+" + y2)) return false;
        return area == (x2 - x1) * (y2 - y1);
    }
}
