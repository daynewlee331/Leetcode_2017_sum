package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Search_Two {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if(board == null || board.length < 1 || words == null || words.length < 1) return res;
		Trie trie = new Trie();
		for(String word: words) trie.insert(word);
		Set<String> buff = new HashSet<>();
		for(int i = 0; i < board.length; i ++){
			for(int j = 0; j < board[0].length; j ++){
				search(i, j, board, "", trie, buff);
			}
		}
		return new ArrayList<>(buff);
    }
	
	public void search(int i, int j, char[][] board, String str, Trie trie, Set<String> res){
		if(board[i][j] == '*') return;
		char tmp = board[i][j];
		str += tmp;
		if(!trie.startsWith(str)) return;
		if(trie.search(str)) {
			res.add(str);
		}
		board[i][j] = '*';
		if(i - 1 >= 0) search(i - 1, j, board, str, trie, res);
		if(i + 1 < board.length) search(i + 1, j, board, str, trie, res);
		if(j - 1 >= 0) search(i, j - 1, board, str, trie, res);
		if(j + 1 < board[0].length) search(i, j + 1, board, str, trie, res);
		board[i][j] = tmp;
	}
}
