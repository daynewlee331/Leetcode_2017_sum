package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Best_Meeting_Point {
	public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length < 1) return 0;
        List<Integer> xAxis = new ArrayList<>();
        List<Integer> yAxis = new ArrayList<>();
        for(int i = 0; i < grid.length; i ++){
        	for(int j = 0; j < grid[0].length; j ++){
        		if(grid[i][j] == 1) {
        			xAxis.add(i);
        			yAxis.add(j);
        		}
        	}
        }
        return getDist(xAxis) + getDist(yAxis);
        
    }
	
	private int getDist(List<Integer> list){
		Collections.sort(list);
		int i = 0, j = list.size() - 1, res = 0;
		while(i < j){
			res += list.get(j) - list.get(i);
			i ++;
			j --;
		}
		return res;
	}
}
