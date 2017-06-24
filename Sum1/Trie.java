package Sum1;

public class Trie {
	class Node{
		Node[] children = null;
		boolean isWord = false;
		char c = '*';
		Node(){
			children = new Node[26];
			isWord = false;
		}
	}
	Node head = null;
	/** Initialize your data structure here. */
    public Trie() {
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
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = head;
        for(char c: word.toCharArray()){
        		if(cur.children[c - 'a'] == null) return false;
        		cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = head;
        for(char c: prefix.toCharArray()){
        		if(cur.children[c - 'a'] == null) return false;
        		cur = cur.children[c - 'a'];
        }
        return true;
    }
}
