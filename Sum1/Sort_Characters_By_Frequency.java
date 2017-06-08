package Sum1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sort_Characters_By_Frequency {
	public String frequencySort(String s) {
		if(s == null || s.isEmpty()) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char c: s.toCharArray()){
        	Integer cnt = map.get(c);
        	if(cnt == null) map.put(c, 1);
        	else map.put(c, cnt + 1);
        	max = Math.max(max, map.get(c));
        }
        List<Character>[] arr = new List[max + 1];
        for(char c: map.keySet()){
        	int index = map.get(c);
        	if(arr[index] == null) arr[index] = new ArrayList<Character>();
        	for(int i = 0; i < index; i ++) arr[index].add(c);
        }
        StringBuilder builder = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i --){
        	if(arr[i] == null) continue;
        	for(char c: arr[i]) builder.append(c);
        }
        return builder.toString();
    }
}
