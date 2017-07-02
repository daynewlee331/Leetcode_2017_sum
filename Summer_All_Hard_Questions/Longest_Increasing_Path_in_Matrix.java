package Summer_All_Hard_Questions;

public class Longest_Increasing_Path_in_Matrix {
	private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length < 1) return 0;
        int max = 0, m = matrix.length, n = matrix[0].length;
        Integer[][] cache = new Integer[m][n];
        for(int i = 0; i < m; i ++){
        		for(int j = 0; j < n; j ++){
        			int len = searchLength(i, j, matrix, cache);
        			max = Math.max(max, len);
        		}
        }
        return max;
    }
	
	public int searchLength(int i, int j, int[][] matrix, Integer[][] cache){
		if(cache[i][j] != null) return cache[i][j];
		int localMax = 1;
		for(int[] dir: dirs){
			int x = i + dir[0], y = j + dir[1];
			if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
				int len = 1 + searchLength(x, y, matrix, cache);
				localMax = Math.max(len, localMax);
			}
		}
		cache[i][j] = localMax;
		return localMax;
	}
}	
