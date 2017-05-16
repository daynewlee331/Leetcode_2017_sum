package Sum1;

import java.util.HashMap;
import java.util.Map;

public class Strobogrammatic_Number {
	public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('8', '8'); map.put('1', '1');
        map.put('6', '9'); map.put('9', '6');
        map.put('0', '0');
        int i = 0, j = num.length() - 1;
        while(i < j){
        		char left = num.charAt(i ++), right = num.charAt(j --);
        		Character match = map.get(left);
        		if(match == null) return false;
        		if(match != right) return false;
        }
        if(i == j){
        		if(num.charAt(i) != '1' && num.charAt(i) != '8'&& num.charAt(i) != '0') return false;
        }
        return true;
    }
}
