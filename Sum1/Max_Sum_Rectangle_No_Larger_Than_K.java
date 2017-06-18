package Sum1;

import java.util.TreeSet;

public class Max_Sum_Rectangle_No_Larger_Than_K {
	
	//borrowed the idea from continuous subarray sum equals(no larger than) K
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if(matrix == null || matrix.length < 1) return 0;
        int m = matrix.length, n = matrix[0].length, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++){
        		int[] buff = new int[m];
        		for(int j = i; j < n; j ++){
        			for(int p = 0; p < m; p ++){
        				buff[p] += matrix[p][j];
        			}
        			int sum = 0;
        			TreeSet<Integer> set = new TreeSet<>();
        			set.add(0);
        			for(int p = 0; p < m; p ++){
        				sum += buff[p];
        				Integer val = set.ceiling(sum - k);
        				if(val != null) {
        					if(max < sum - val) max = sum - val;
        				}
        				set.add(sum);
        			}
        		}
        }
        return max;
	}
	
	public int maxSumSubmatrixNaive(int[][] matrix, int k) {
        if(matrix == null || matrix.length < 1) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] area = new int[m][n];
        for(int i = 0; i < m; i ++){
        		for(int j = 0; j < n; j ++){
        			area[i][j] = matrix[i][j];
        			if(i - 1 >= 0) area[i][j] += area[i - 1][j];
        			if(j - 1 >= 0) area[i][j] += area[i][j - 1];
        			if(i - 1 >= 0 && j - 1 >= 0) area[i][j] -= area[i - 1][j - 1];
        		}
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i ++){
        		for(int j = 0; j < n; j ++){
        			for(int p = i; p < m; p ++){
        				for(int q = j; q < n; q ++){
        					int a = area[p][q];
        					if(i - 1 >= 0) a -= area[i - 1][q];
        					if(j - 1 >= 0) a -= area[p][j - 1];
        					if(i - 1 >= 0 && j - 1 >= 0) a += area[i - 1][j - 1];
        					if(a <= k) max = Math.max(max, a);
        				}
        			}
        		}
        }
        return max;
    }
}
