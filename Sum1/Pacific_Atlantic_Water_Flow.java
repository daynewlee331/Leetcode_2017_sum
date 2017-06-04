package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if(matrix == null || matrix.length < 1) return res;
		
		int m = matrix.length, n = matrix[0].length;
		boolean[][] Pacific = new boolean[m][n];
		boolean[][] Atlantic = new boolean[m][n];
		
		//upper border and lower border
		for(int j = 0; j < n; j ++){
			search(0, j, Pacific, matrix);
			search(m - 1, j, Atlantic, matrix);
		}
		
		//left border and right border
		for(int i = 0; i < m; i ++){
			search(i, 0, Pacific, matrix);
			search(i, n - 1, Atlantic, matrix);
		}
		
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j ++){
				if(Pacific[i][j] && Atlantic[i][j]) res.add(new int[]{i,j});
			}
		}
		
		return res;
    }
	
	public void search(int i, int j, boolean[][] board, int[][] matrix){
		if(board[i][j]) return;
		board[i][j] = true;
		int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		for(int[] dir: dirs){
			int p = i + dir[0], q = j + dir[1];
			//out of bound
			if(p < 0 || q < 0 || p >= board.length || q >= board[0].length || matrix[p][q] < matrix[i][j]) continue;
			search(p , q, board, matrix);
		}
	}
}
