package Sum1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Number_of_Connected_Nodes_in_Undirected_Graph {
	public int countComponents(int n, int[][] edges) {
		Map<Integer, Set<Integer>> adjList = new HashMap<Integer, Set<Integer>>();
		Set<Integer> visited = new HashSet<Integer>();
		for(int[] edge: edges){
			if(!adjList.containsKey(edge[0])) adjList.put(edge[0], new HashSet<Integer>());
			if(!adjList.containsKey(edge[1])) adjList.put(edge[1], new HashSet<Integer>());
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		int res = 0;
		for(int i = 0; i < n; i ++){
			if(!visited.contains(i)){
				search(i, adjList, visited);
				res ++;
			}
		}
		return res;
    }
	
	public void search(int k, Map<Integer, Set<Integer>> adjList, Set<Integer> visited){
		if(visited.contains(k)) return;
		visited.add(k);
		if(adjList.containsKey(k)){
			for(int neighbor: adjList.get(k)){
				search(neighbor, adjList, visited);
			}
		}
	}
}
