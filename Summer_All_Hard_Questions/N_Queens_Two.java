package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens_Two {
	public int totalNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];
		for(char[] row: board) Arrays.fill(row, '.');
		search(0, board, res);
		return res.size();
    }
	
	public void search(int row, char[][]board, List<List<String>> res){
		if(row == board.length){
			List<String> cur = new ArrayList<>();
			for(char[] line: board) cur.add(new String(line));
			res.add(cur);
			return;
		}
		for(int i = 0; i < board.length; i ++){
			if(board[row][i] != '.') continue;
			if(isValid(row, i, board)) {
                board[row][i] = 'Q'; 
                search(row + 1, board, res);
			    board[row][i] = '.';    
            }
		}
	}
	
	private boolean isValid(int row, int col, char[][] board){
		for(int i = 0; i < board.length; i ++){
			if(board[row][i] == 'Q') return false;
			if(board[i][col] == 'Q') return false;
		}
		int x = row + 1, y = col + 1;
		while(x < board.length && y < board.length){
			if(board[x ++][y ++] == 'Q') return false;
		}
		
		x = row - 1;
		y = col - 1;
		while(x >= 0 && y >= 0){
			if(board[x --][y --] == 'Q') return false;
		}
		
		x = row + 1;
		y = col - 1;
		while(x < board.length && y >= 0) {
			if(board[x ++][y --] == 'Q') return false;
		}
		
		x = row - 1;
		y = col + 1;
		while(x >= 0 && y < board.length) {
			if(board[x --][y ++] == 'Q') return false;
		}
		return true;
	}
}
