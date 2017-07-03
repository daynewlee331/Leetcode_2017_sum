package Summer_All_Hard_Questions;

public class Sudoku_Solver {
	public void solveSudoku(char[][] board) {
		if(board == null || board.length < 1) return;
		isSolved(board);
    }
	
	public boolean isSolved(char[][] board){
		int m = board.length, n = board[0].length;
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j ++){
				if(board[i][j] != '.') continue;
				for(char c = '1'; c <= '9'; c ++){
					if(isValid(i, j, c, board)) {
						board[i][j] = c;
						if(isSolved(board)) return true;
						board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}
	
	public boolean isValid(int row, int col, char c, char[][] board){
		for(int i = 0; i < board.length; i ++){
			if(board[row][i] == c) return false;
			if(board[i][col] == c) return false;
		}
		int a = (row / 3) * 3, b = (col / 3) * 3;
		for(int p = a; p < a + 3; p ++){
			for(int q = b; q < b + 3; q ++){
				if(board[p][q] == c) return false;
			}
		}
		return true;
	}
}
