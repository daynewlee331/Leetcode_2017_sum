package Summer_All_Hard_Questions;

import java.util.HashMap;

public class Longest_Substring_K_Distinct_Characters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0, max = 0;
        for(int i = 0; i < s.length(); i ++){
        		char c = chars[i];
        		if(!map.containsKey(c)) map.put(c, 1);
        		else map.put(c, map.get(c) + 1);
        		while(map.size() > k){
        			char ch = chars[left];
        			int num = map.get(ch);
        			if(num - 1 == 0) map.remove(ch);
        			else map.put(ch, num - 1);
        			left ++;
        		}
        		max = Math.max(i - left + 1, max);
        }
        return max;
    }
}
