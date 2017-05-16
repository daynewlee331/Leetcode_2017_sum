package Sum1;
public class Find_Difference {
	public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        Character res = null;
        for(char c: s.toCharArray()) arr[c - 'a'] ++;
        for(char c: t.toCharArray()) {
        		arr[c - 'a'] --;
        		if(arr[c - 'a'] < 0) res = c;
        }
        return res;
    }
}
