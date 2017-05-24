package Sum1;

public class Repeated_Substring_Pattern {
	public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = len / 2; i >= 1; i --){
        		if(len % i == 0){
        			String pattern = s.substring(0, i);
        			StringBuilder copy = new StringBuilder();
        			for(int k = 0; k < len / i; k ++){
        				copy.append(pattern);
        			}
        			if(s.equals(copy.toString())) return true;
        		}
        }
        return false;
    }
}
