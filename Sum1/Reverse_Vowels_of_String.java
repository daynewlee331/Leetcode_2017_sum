package Sum1;

public class Reverse_Vowels_of_String {
	public String reverseVowels(String s) {
        if(s == null) return null;
        String vowels = "aeiouAEIOU";
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while(i < j){
        	while(i < j && !vowels.contains(chars[i]+"")) i++;
        	while(i < j && !vowels.contains(chars[j]+"")) j--;
        	if(i < j) {
        		char tmp = chars[i];
        		chars[i] = chars[j];
        		chars[j] = tmp;
        		i ++; j --;
        	}
        }
        return new String(chars);
    }
}
