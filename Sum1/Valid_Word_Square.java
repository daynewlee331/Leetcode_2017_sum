package Sum1;

import java.util.List;

public class Valid_Word_Square {
	public boolean validWordSquare(List<String> words) {
        if(words.size() < 1) return true;
        for(int i = 0; i < words.size(); i ++){
        		String word = words.get(i);
        		for(int j = 0; j < word.length(); j ++){
        			char c = word.charAt(j);
        			if(words.size() <= j) return false;
        			String tmp = words.get(j);
        			if(tmp.length() <= i) return false;
        			if(c != words.get(j).charAt(i)) return false;
        		}
        }
        return true;
    }
}
