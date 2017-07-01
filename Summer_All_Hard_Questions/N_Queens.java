package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for(char[] chars: board) Arrays.fill(chars, '.');
		List<List<String>> res = new ArrayList<>();
		search(0, res, board, n);
		return res;
    }
	
	public void search(int row, List<List<String>> res, char[][] board, int n){
		if(row == n){
			List<String> list = new ArrayList<>();
			for(char[] chars: board) list.add(new String(chars));
			res.add(list);
			return;
		}
		for(int col = 0; col < board[0].length; col ++){
			if(isValid(row, col, board, n)) board[row][col] = 'Q';
			else continue;
			search(row + 1, res, board, n);
			board[row][col] = '.';
		}
	}
	
	private boolean isValid(int i, int j, char[][]board, int n){
		for(int a = 0; a < n; a ++){
			if(board[i][a] == 'Q') return false;
			if(board[a][j] == 'Q') return false;
		}
		int x = i + 1, y = j + 1;
		while(x < n && y < n) {
			if(board[x ++][y ++] == 'Q') return false;
		}
		x = i - 1; y = j - 1;
		while(x >= 0 && y >= 0) {
			if(board[x --][y --] == 'Q') return false;
		}
		x = i + 1; y = j - 1;
		while(x < n && y >= 0) {
			if(board[x ++][y --] == 'Q') return false;
		}
		x = i - 1; y = j + 1;
		while(x >= 0 && y < n) {
			if(board[x --][y ++] == 'Q') return false;
		}
		return true;
	}
}
