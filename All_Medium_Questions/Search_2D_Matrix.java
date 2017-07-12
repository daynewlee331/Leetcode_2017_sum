package All_Medium_Questions;

public class Search_2D_Matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target);
    }
	
	public boolean search(int[][] arr, int target){
		int m = arr.length, n = arr[0].length;
		int i = 0, j = m * n - 1;
		while(i <= j){
			int mid = (j - i) / 2 + i;
			int matrix_mid = arr[mid / n][mid % n];
			if(matrix_mid == target) return true;
			else if(matrix_mid < target) {
				i = mid + 1;
			}else j = mid - 1;
		}
		return false;
	}
}
