package Sum1;

public class Game_Of_Life {
int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
	
	public void gameOfLife(int[][] board) {
        if(board == null || board.length < 1) return;
        for(int i = 0; i < board.length; i ++){
        	for(int j = 0; j < board[0].length; j ++){
        	    int cnt = countLive(i, j, board);
        		if(board[i][j] == 1 && (cnt < 2 || cnt > 3)) board[i][j] = 2;
        		else if(board[i][j] == 0 && cnt == 3) board[i][j] = 3;
        	}
        }
        
        for(int i = 0; i < board.length; i ++){
        	for(int j = 0; j < board[0].length; j ++){
        		board[i][j] %= 2;
        	}
        }
    }
	
	public int countLive(int row, int col, int[][] board){
		int count = 0;
		for(int[] dir: dirs){
			int p = row + dir[0], q = col + dir[1];
			if(p < 0 || q < 0 || p >= board.length || q >= board[0].length) continue;
			if(board[p][q] == 1 || board[p][q] == 2) count ++;
		}
		return count;
	}
}
