package Sum1;

public class Longest_Increasing_Path_in_Matrix {
	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length < 1) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i ++){
        	for(int j = 0; j < n; j ++){
        		int len = dfs(i, j, matrix, cache);
        		max = Math.max(max, len);
        	}
        }
        return max;
    }
	
	public int dfs(int row, int col, int[][] matrix, int[][] cache){
		if(cache[row][col] != 0) return cache[row][col];
		int max = 1;
		for(int[] dir: dirs){
			int x = row + dir[0], y = col + dir[1];
			if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) continue;
			if(matrix[x][y] <= matrix[row][col]) continue;
			int len = 1 + dfs(x, y, matrix, cache);
			max = Math.max(max, len);
		}
		cache[row][col] = max;
		return max;
	}
}
