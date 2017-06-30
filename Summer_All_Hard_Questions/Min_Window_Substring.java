package Summer_All_Hard_Questions;

import java.util.HashMap;

public class Min_Window_Substring {
	public static void main(String[] args){
		Min_Window_Substring sol = new Min_Window_Substring();
		sol.minWindow("A", "A");
	}
	
	public String minWindow(String s, String t) {
        if(s == null || s.isEmpty() || t == null || t.isEmpty()) return null;
        HashMap<Character, Integer> map = new HashMap<>();
        int total = 0;
        for(char c: t.toCharArray()) {
        		Integer cnt = map.get(c);
        		if(cnt == null) map.put(c, 1);
        		else map.put(c, cnt + 1);
        		total ++;
        }
        int i = 0, j = 0, min = s.length() + 1;
        String res = "";
        char[] chars = s.toCharArray();
        int count = 0;
        while(i < s.length()){
        		char c = chars[i];
        		if(map.containsKey(c)){
        			int num = map.get(c);
    				map.put(c, num - 1);
        			if(map.get(c) >= 0) count ++;
        		}
        		while(count == total && j < s.length()){
        			char ch = chars[j];
        			if(map.containsKey(ch)){
        				int n = map.get(ch);
        				map.put(ch, n + 1);
        				if(map.get(ch) > 0) count --;
        			}
        			if(i - j + 1 < min){
        				min = i - j + 1;
        				res = s.substring(j, i + 1);
        			}
        			j ++;
        		}
        		i ++;
        }
        return res;
    }
}
