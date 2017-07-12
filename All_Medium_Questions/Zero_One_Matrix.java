package All_Medium_Questions;

import java.util.LinkedList;
import java.util.Queue;

public class Zero_One_Matrix {
	public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix[0].length < 1) return matrix;
        int m = matrix.length, n = matrix[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i ++){
        		for(int j = 0; j < n; j ++){
        			if(matrix[i][j] == 1) matrix[i][j] = Integer.MAX_VALUE;
        			else queue.offer(new int[]{i, j});
        		}
        }
        while(!queue.isEmpty()){
        		int[] cur = queue.poll();
        		for(int[] dir: dirs){
        			int x = cur[0] + dir[0], y = cur[1] + dir[1];
        			if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] < matrix[cur[0]][cur[1]] + 1) continue;
        			queue.offer(new int[]{x, y});
        			matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
        		}
        }
        return matrix;
    }
}
