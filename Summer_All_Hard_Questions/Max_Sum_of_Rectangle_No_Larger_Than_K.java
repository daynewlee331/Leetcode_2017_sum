package Summer_All_Hard_Questions;

import java.util.TreeSet;

public class Max_Sum_of_Rectangle_No_Larger_Than_K {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if(matrix == null || matrix.length < 1) return 0;
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for(int left = 0; left < n; left ++){
        		int[] buffer = new int[m];
        		for(int right = left; right < n; right ++){
        			for(int i = 0; i < m; i ++) buffer[i] += matrix[i][right];
        			TreeSet<Integer> set = new TreeSet<>();
        			set.add(0);
        			int localSum = 0;
        			for(int j = 0; j < m; j ++){
        				localSum += buffer[j];
        				Integer num = set.ceiling(localSum - k);
        				if(num != null) {
                            if(res < localSum - num) res = localSum - num;
                        }
        				set.add(localSum);
        			}
        		}
        }
        return res;
    }
}
