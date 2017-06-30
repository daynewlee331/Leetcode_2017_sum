package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_Two {
	public static void main(String[] args){
		Word_Ladder_Two sol = new Word_Ladder_Two();
		sol.findLadders("hot", "dog", Arrays.asList(new String[]{"hot","dog"}));
	}
	
	private Integer length = null;
	private HashMap<String, Set<String>> adjList = new HashMap<>();
	private HashMap<String, Integer> path = new HashMap<>();
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		if(beginWord == null || beginWord.isEmpty() 
				|| endWord == null || endWord.isEmpty()) return res;
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;
        BFS(beginWord, endWord, dict);
        if(this.length == null) return res;
        List<String> cur = new ArrayList<>();
        cur.add(beginWord);
        DFS(beginWord, endWord, cur, res);
        	return res;
    }
	
	public void DFS(String word, String endWord, List<String> cur, List<List<String>> res){
		if(cur.size() == this.length && word.equals(endWord)) {
			res.add(new ArrayList<>(cur));
			return;
		}
		if(adjList.containsKey(word)){
			int dist = this.path.get(word);
			for(String neighbor: adjList.get(word)){
				if(this.path.get(neighbor) != dist + 1) continue;
				cur.add(neighbor);
				DFS(neighbor, endWord, cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	public void BFS(String beginWord, String endWord, Set<String> dict){
		Queue<String> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		queue.add(beginWord);
		visited.add(beginWord);
		this.path.put(beginWord, 0);
		int len = 1;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i ++){
				String cur = queue.poll();
				if(!this.adjList.containsKey(cur)) this.adjList.put(cur, new HashSet<>());
				int dist = this.path.get(cur);
				for(String neighbor: getNeighbors(cur, dict)){
					adjList.get(cur).add(neighbor);
					if(visited.contains(neighbor)) continue;
					if(neighbor.equals(endWord) && this.length == null) {
						this.length = len + 1;
					}
					this.path.put(neighbor, dist + 1);
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
			if(this.length != null) break;
			len ++;
		}
	}
	
	public List<String> getNeighbors(String word, Set<String> dict){
		char[] chars = word.toCharArray();
		List<String> res = new ArrayList<>();
		for(int i = 0; i < chars.length; i ++){
			char tmp = chars[i];
			for(char c = 'a'; c <= 'z'; c ++){
				chars[i] = c;
				String s = new String(chars);
				if(!s.equals(word) && dict.contains(s)) res.add(s);
			}
			chars[i] = tmp;
		}
		return res;
	}
}
