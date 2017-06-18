package Sum1;

import java.util.HashMap;

public class Longest_Substring_with_At_Most_Two_Distinct_Characters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s == null || s.length() < 1) return 0;
        int i = 0, j = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
        			Integer cnt = map.get(s.charAt(j));
        			if(cnt == null) map.put(s.charAt(j), 1);
        			else map.put(s.charAt(j), cnt + 1);
        			j ++;
        		while(i < j && map.keySet().size() > 2){
        			Integer count = map.get(s.charAt(i));
        			map.put(s.charAt(i), count - 1);
        			if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
        			i ++;
        		}
        		max = Math.max(max, j - i);
        		
        }
        return max;
    }
}
