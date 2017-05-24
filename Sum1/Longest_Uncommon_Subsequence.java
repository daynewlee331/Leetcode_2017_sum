package Sum1;

public class Longest_Uncommon_Subsequence {
	public int findLUSlength(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        if(a.equals(b)) return -1;
        else return Math.max(lenA, lenB);
    }
}
