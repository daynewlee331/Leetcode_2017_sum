package Sum1;

public class Longest_Palindrome {
	public int longestPalindrome(String s) {
        if(s == null || s.isEmpty()) return 0;
        int[] map = new int[58];
        int countEven = 0, countOdd = 0;
        for(char c: s.toCharArray()){
        	map[c - 'A'] ++;
        }
        for(int i = 0; i < map.length; i ++){
        	countEven += (map[i] / 2) * 2;
        	countOdd += map[i] % 2;
        }
        return countOdd > 0? countEven + 1 : countEven;
    }
}
