package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;

public class WordSquareTrie {
	/** Initialize your data structure here. */
	private Node head = null;
    public WordSquareTrie() {
        head = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = head;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i ++){
        		char c = chars[i];
        		if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
        		cur = cur.children[c - 'a'];
        		cur.words.add(word);
        }
        //cur.words.add(word);
        cur.isWord = true;
    }
    
    public List<String> getWordsByPrefix(String prefix){
    	Node cur = head;
        char[] chars = prefix.toCharArray();
        for(int i = 0; i < chars.length; i ++){
        		char c = chars[i];
        		if(cur.children[c - 'a'] == null) return null;
        		cur = cur.children[c - 'a'];
        }
        return cur.words;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    		Node cur = head;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i ++){
        		char c = chars[i];
        		if(cur.children[c - 'a'] == null) return false;
        		cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
    
    class Node{
    		Node[] children = null;
    		boolean isWord = false;
    		List<String> words = null;
    		public Node(){
    			this.children = new Node[26];
    			isWord = false;
    			words = new ArrayList<>();
    		}
    }
}
