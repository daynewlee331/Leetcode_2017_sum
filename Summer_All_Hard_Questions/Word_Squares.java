package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;

public class Word_Squares {
	private WordSquareTrie trie = new WordSquareTrie();
	
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> res = new ArrayList<>();
		if(words == null || words.length < 1) return res;
		for(String s: words) trie.insert(s);
		for(String word: words){
			List<String> cur = new ArrayList<>();
			cur.add(word);
			search(cur, res, word.length());
		}
		return res;
    }
	
	public void search(List<String> cur, List<List<String>> res, int size){
		if(cur.size() == size){
			res.add(new ArrayList<>(cur));
			return;
		}
		int col = cur.size();
		StringBuilder builder = new StringBuilder();
		for(String word: cur) builder.append(word.charAt(col));
		String prefix = builder.toString();
		List<String> candidates = trie.getWordsByPrefix(prefix);
		if(candidates != null){
			for(String candidate: candidates){
				cur.add(candidate);
				search(cur, res, size);
				cur.remove(cur.size() - 1);
			}
		}
	}
}
