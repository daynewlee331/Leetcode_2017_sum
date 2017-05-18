package Sum1;

public class Island_Perimeter {
	public boolean connectWater(int i, int j, int[][] grid){
		if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length){
			return grid[i][j] == 0;
		}
		//hit the border/water
		return true;
	}
	
	public int islandPerimeter(int[][] grid) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        if(grid == null || grid.length < 1) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i ++){
        		for(int j = 0; j < grid[0].length; j ++){
        			if(grid[i][j] == 1){
        				for(int[] dir: dirs){
        					if(connectWater(i + dir[0], j + dir[1], grid)) res ++;
        				}
        			}
        		}
        }
        return res;
    }
}
