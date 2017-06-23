package Sum1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//http://massivealgorithms.blogspot.com/2015/10/leetcode-best-meeting-point-segmentfault.html
public class Best_Meeting_Point {
	public int minTotalDistance(int[][] grid) {
        if(grid == null || grid[0].length < 1) return 0;
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i ++){
        		for(int j = 0; j < n; j ++){
        			if(grid[i][j] == 1) {
        				I.add(i);
        				J.add(j);
        			}
        		}
        }
        return getMin(I) + getMin(J);
    } 
	
	public int getMin(List<Integer> list){
		Collections.sort(list);
		int p = 0, q = list.size() - 1;
		int res = 0;
		while(p < q){
			res += list.get(q --);
			res -= list.get(p ++);
		}
		return res;
	}
	
}
