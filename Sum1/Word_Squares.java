package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Word_Squares {
	public static void main(String[] args){
		Word_Squares sol = new Word_Squares();
		sol.wordSquares(new String[]{"area","lead","wall","lady","ball"});
	}
	
	WordSquareTrie trie = new WordSquareTrie();
	public List<List<String>> wordSquares(String[] words) {
        for(String s: words) trie.insert(s);
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        for(String s: words){
        		cur.add(s);
        		search(cur, res, s.length());
        		cur.remove(cur.size() - 1);
        }
        return res;
    }
	
	public void search(List<String> cur, List<List<String>> res, int size){
		if(cur.size() == size) {
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
