package Summer_All_Hard_Questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Sequence_Reconstruction {
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		if (org == null || org.length < 1) return false;
		Map<Integer, Set<Integer>> adjList = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for (List<Integer> list : seqs) {
			if (list.size() == 1) {
				if (!inDegree.containsKey(list.get(0))) {
					inDegree.put(list.get(0), 0);
				}
			} else {
				for (int i = 0; i + 1 < list.size(); i++) {
					int from = list.get(i);
					int to = list.get(i + 1);
					if (!adjList.containsKey(from)) adjList.put(from, new HashSet<>());
					if (!inDegree.containsKey(from)) inDegree.put(from, 0);
					if (!inDegree.containsKey(to)) inDegree.put(to, 0);
					if (!adjList.get(from).contains(to)) {
						adjList.get(from).add(to);
						inDegree.put(to, inDegree.get(to) + 1);
					}
				}
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		int index = 0;
		for (int i : inDegree.keySet()) {
			if (inDegree.get(i) == 0) queue.add(i);
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (size > 1) return false;
			int node = queue.poll();
			if (index == org.length || node != org[index]) return false;
			index++;
			if (adjList.containsKey(node)) {
				for (int neighbor : adjList.get(node)) {
					int degree = inDegree.get(neighbor);
					inDegree.put(neighbor, degree - 1);
					if (inDegree.get(neighbor) == 0) {
						queue.offer(neighbor);
					}
				}
			}
		}
		return index == org.length && index == inDegree.size();
	}
}
