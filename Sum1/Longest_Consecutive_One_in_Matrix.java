package Sum1;

public class Longest_Consecutive_One_in_Matrix {
	int res = 0;
	public int longestLine(int[][] M) {
		if(M == null || M.length < 1) return 0;
		int[] col = new int[M[0].length];
        for(int i = 0; i < M.length; i ++){
        		int row = 0;
        		for(int j = 0; j < M[0].length; j ++){
        			if(M[i][j] == 1){
        				row ++;
        				col[j] ++;
        				res = Math.max(row, res);
        				res = Math.max(col[j], res);
        			}else{
        				row = 0;
        				col[j] = 0;
        			}
        		}
        }
        
        for(int i = 0; i < M.length; i ++){
    			for(int j = 0; j < M[0].length; j ++){
    				search(i, j, M);
    			}
        }
        return res;
        
    }
	public void search(int i, int j, int[][] M){
		int len = 0;
		int tmp1 = i;
		int tmp2 = j;
		len = 0;
		i = tmp1;
		j = tmp2;
		while(i < M.length && j < M[0].length && M[i][j] == 1){
			len ++;
			res = Math.max(res, len);
			i ++;
			j ++;
		}
		len = 0;
		i = tmp1;
		j = tmp2;
		while(i < M.length && j < M[0].length && i >= 0 && j >= 0 && M[i][j] == 1){
			len ++;
			res = Math.max(res, len);
			i --;
			j ++;
		}
	}
}
