package Sum1;

public class Search_2D_Matrix_Two {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while(i >= 0 && i < m && j >= 0 && j < n){
        	if(matrix[i][j] > target){
        		i --;
        	}else if(matrix[i][j] < target){
        		j ++;
        	}else return true;
        }
        return false;
    }
}
