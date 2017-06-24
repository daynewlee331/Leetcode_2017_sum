package Sum1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_Two {
	Map<String, Integer> distances = new HashMap<>();
	Integer length = null;
	/*
	public static void main(String[] args){
		Word_Ladder_Two sol = new Word_Ladder_Two();
		List<String> wordList = Arrays.asList("hot","dog","dot");
		sol.findLadders("hot", "dog", wordList);
	}*/
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(wordList == null || wordList.size() < 1 || !wordList.contains(endWord)) return res;
		Map<String, Set<String>> adjList = new HashMap<>();
		BFSHelper(beginWord, endWord, wordList, adjList);
		if(this.length == null) return res;
		Set<String> visited = new HashSet<>();
		List<String> cur = new ArrayList<>();
		cur.add(beginWord);
		visited.add(beginWord);
		DFSHelper(beginWord, endWord, cur, res, visited, adjList);
		return res;
    }
	
	public void DFSHelper(String curWord, String endWord, List<String> cur, List<List<String>> res, Set<String> visited, Map<String, Set<String>> adjList){
		if(curWord.equals(endWord) && cur.size() == this.length) {
			res.add(new ArrayList<>(cur));
			return;
		}
		if(cur.size() >= this.length) return;
		if(adjList.containsKey(curWord)){
			int dist = this.distances.get(curWord);
			for(String neighbor: adjList.get(curWord)){
				if(visited.contains(neighbor)) continue;
				if(this.distances.get(neighbor) != dist + 1) continue;
				cur.add(neighbor);
				visited.add(neighbor);
				DFSHelper(neighbor, endWord, cur, res, visited, adjList);
				cur.remove(cur.size() - 1);
				visited.remove(neighbor);
			}
		}
	}
	
	public void BFSHelper(String beginWord, String endWord, List<String> wordList, Map<String, Set<String>> adjList) {
		Set<String> visited = new HashSet<>();
		Set<String> dict = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		visited.add(beginWord);
		int len = 1;
		distances.put(beginWord, 0);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i ++){
				String cur = queue.poll();
				int dist = distances.get(cur);
				List<String> neighbors = getNeighbors(cur, dict);
				if(!adjList.containsKey(cur)) adjList.put(cur, new HashSet<>());
				for(String neighbor: neighbors){
					adjList.get(cur).add(neighbor);
					if(visited.contains(neighbor)) continue;
					this.distances.put(neighbor, dist + 1);
					if(neighbor.equals(endWord) && this.length == null) {
						this.length = len + 1;
					}
					queue.offer(neighbor);
					visited.add(neighbor);
				}
			}
			len ++;
			if(this.length != null) break;
		}
	}
	
	public List<String> getNeighbors(String cur, Set<String> dict){
		char[] arr = cur.toCharArray();
		List<String> res = new ArrayList<>();
		for(int i = 0; i < arr.length; i ++){
			char tmp = arr[i];
			for(char c = 'a'; c <= 'z'; c ++) {
				arr[i] = c;
				String can = new String(arr);
				if(dict.contains(can) && !can.equalsIgnoreCase(cur)) res.add(can);
			}
			arr[i] = tmp;
		}
		return res;
	}
}
