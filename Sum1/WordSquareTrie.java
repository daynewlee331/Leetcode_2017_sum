package Sum1;

import java.util.ArrayList;
import java.util.List;

public class WordSquareTrie {
	class Node{
		Node[] children = null;
		boolean isWord = false;
		List<String> words = null;
		Node(){
			children = new Node[26];
			isWord = false;
			words = new ArrayList<>();
		}
	}
	Node head = null;
	/** Initialize your data structure here. */
    public WordSquareTrie() {
        head = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = head;
        for(char c: word.toCharArray()){
        		if(cur.children[c - 'a'] == null) {
        			cur.children[c - 'a'] = new Node();
        		}
        		cur = cur.children[c - 'a'];
        		cur.words.add(word);
        }
        cur.words.add(word);
        cur.isWord = true;
    }
    
    public List<String> getWordsByPrefix(String prefix){
    	Node cur = head;
        for(char c: prefix.toCharArray()){
        		if(cur.children[c - 'a'] == null) return null;
        		cur = cur.children[c - 'a'];
        }
        return cur.words;
    }
}
