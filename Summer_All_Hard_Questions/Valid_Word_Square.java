package Summer_All_Hard_Questions;

import java.util.List;

public class Valid_Word_Square {
	public boolean validWordSquare(List<String> words) {
        if(words.size() < 1) return true;
        for(int i = 0; i < words.size(); i ++){
        		String word = words.get(i);
        		for(int j = 0; j < word.length(); j ++){
        			char c1 = word.charAt(j);
        			if(words.size() <= j) return false;
        			if(words.get(j).length() <= i) return false;
        			char c2 = words.get(j).charAt(i);
        			if(c1 != c2) return false;
        		}
        }
        return true;
    }
}
