package Sum1;

import java.util.List;

public class Valid_Word_Square {
	public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() < 1) return true;
        int len = words.size();
        for(int i = 0; i < len; i ++){
        		int k = 0;
        		for(int j = 0; j < words.get(i).length(); j ++){
        			if(k >= words.size()) return false;
        			if(i >= words.get(k).length()) return false;
        			char c = words.get(k).charAt(i);
        			if(words.get(i).charAt(j) != c) return false;
        			k ++;
        		}
        }
        return true;
    }
}
