package Summer_All_Hard_Questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Alien_Dictionary {
	public static void main(String[] args) {
		Alien_Dictionary sol = new Alien_Dictionary();
		sol.alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt", "te" });
	}

	public String alienOrder(String[] words) {
		if (words == null || words.length < 1)
			return "";
		Map<Character, Set<Character>> adjList = new HashMap<>();
		Map<Character, Integer> inDegree = new HashMap<>();
		for (String s : words) {
			for (char c : s.toCharArray())
				inDegree.put(c, 0);
		}
		for (int i = 0; i + 1 < words.length; i++) {
			String w1 = words[i], w2 = words[i + 1];
			if (w1.equals(w2))
				continue;
			if (w1.startsWith(w2))
				continue;
			int len = Math.min(w1.length(), w2.length());
			for (int j = 0; j < len; j++) {
				char c1 = w1.charAt(j), c2 = w2.charAt(j);
				if (c1 != c2) {
					if (!adjList.containsKey(c1))
						adjList.put(c1, new HashSet<Character>());
					Integer cnt = inDegree.get(c2);
					if (!adjList.get(c1).contains(c2)) {
						adjList.get(c1).add(c2);
						inDegree.put(c2, cnt + 1);
					}
					break;
				}
			}
		}
		Queue<Character> queue = new LinkedList<>();
		StringBuilder builder = new StringBuilder();
		for (char c : inDegree.keySet()) {
			if (inDegree.get(c) == 0) {
				queue.offer(c);
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				char node = queue.poll();
				builder.append(node);
				if (!adjList.containsKey(node))
					continue;
				for (char neighbor : adjList.get(node)) {
					int degree = inDegree.get(neighbor);
					inDegree.put(neighbor, degree - 1);
					if (inDegree.get(neighbor) == 0)
						queue.offer(neighbor);
				}
			}
		}
		return builder.length() == inDegree.size() ? builder.toString() : "";
	}
}
