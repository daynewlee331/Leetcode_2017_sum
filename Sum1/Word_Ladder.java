package Sum1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Ladder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        Set<String> forwardQ = new HashSet<>();
        Set<String> backwardQ = new HashSet<>();
        forwardQ.add(beginWord);
        backwardQ.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int len = 1;
        while(!forwardQ.isEmpty()){
        	int size = forwardQ.size();
        	Set<String> buff = new HashSet<>();
        	for(int i = 0; i < size; i ++){
        		String cur = forwardQ.iterator().next();
            	forwardQ.remove(cur);
            	List<String> neighbors = getNeighbors(cur, dict);
            	for(String neighbor: neighbors){
            		if(backwardQ.contains(neighbor)) return len + 1;
            		if(!visited.contains(neighbor)) {
            			buff.add(neighbor);
            			visited.add(neighbor);
            		}
            	}
        	}
        	forwardQ = buff;
        	if(forwardQ.size() > backwardQ.size()){
        		Set<String> tmp = forwardQ;
        		forwardQ = backwardQ;
        		backwardQ = tmp;
        	}
        	len ++;
        }
        
        return 0;
    }
	
	public List<String> getNeighbors(String cur, Set<String> dict){
		char[] arr = cur.toCharArray();
		List<String> res = new ArrayList<>();
		for(int i = 0; i < arr.length; i ++){
			char tmp = arr[i];
			for(char c = 'a'; c <= 'z'; c ++) {
				arr[i] = c;
				String can = new String(arr);
				if(dict.contains(can)) res.add(can);
			}
			arr[i] = tmp;
		}
		return res;
	}
}
