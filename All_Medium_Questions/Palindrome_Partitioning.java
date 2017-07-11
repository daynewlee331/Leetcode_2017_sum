package All_Medium_Questions;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if(s == null || s.length() < 1) return res;
		search(s, 0, new ArrayList<String>(), res);
		return res;
    }
	
	public void search(String s, int start, List<String> cur, List<List<String>> res){
		if(start == s.length()) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for(int i = start + 1; i <= s.length(); i ++){
			String sub = s.substring(start, i);
			if(isPalindrome(sub)){
				cur.add(sub);
				search(s, i, cur, res);
                cur.remove(cur.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String s){
		if(s.isEmpty()) return false;
		int i = 0, j = s.length() - 1;
		while(i < j){
			if(s.charAt(i ++) != s.charAt(j --)) return false;
		}
		return true;
	}
}	
