package Sum1;

public class Detect_Capital {
	public boolean detectCapitalUse(String word) {
        int count = 0;
        for(char c: word.toCharArray()){
        		if('Z' - c >= 0) count ++;
        }
        return (count == 0 || count == word.length()) || ('Z' - word.charAt(0) >= 0 && count == 1);
    }
}
