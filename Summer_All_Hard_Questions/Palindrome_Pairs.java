package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Palindrome_Pairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		if(words == null || words.length < 1) return res;
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < words.length; i ++) map.put(words[i], i);
		if(map.containsKey("")) {
			int blank = map.get("");
			for(String word: words){
				if(isPalindrome(word)) {
					int index = map.get(word);
                    if(index == blank) continue;
					res.add(Arrays.asList(blank, index));
					res.add(Arrays.asList(index, blank));
				}
			}
		}
		
		for(int j = 0; j < words.length; j ++){
			if(words[j].equals("")) continue;
			String target = getReverse(words[j]);
			Integer index = map.get(target);
			if(index != null && index != j) {
				res.add(Arrays.asList(j, index));
			}
		}
		
		for(int k = 0; k < words.length; k ++){
			if(words[k].equals("")) continue;
			String word = words[k];
			for(int cut = 1; cut < word.length(); cut ++){
				if(isPalindrome(word.substring(0, cut))){
					String reverse = getReverse(word.substring(cut));
					Integer index = map.get(reverse);
					if(index != null && index != k) res.add(Arrays.asList(index, k));
				}
				if(isPalindrome(word.substring(cut))){
					String reverse = getReverse(word.substring(0, cut));
					Integer index = map.get(reverse);
					if(index != null && index != k) res.add(Arrays.asList(k, index));
				}
			}
		}
		return res;
	}
	
	private String getReverse(String word){
		return new StringBuilder(word).reverse().toString();
	}
	
	private boolean isPalindrome(String word){
		int i = 0, j = word.length() - 1;
		char[] chars = word.toCharArray();
		while(i < j){
			if(chars[i ++] != chars[j --]) return false;
		}
		return true;
	}
}
