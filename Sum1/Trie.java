package Sum1;

public class Trie {
	class Node {
		Node[] children = null;
		boolean isWord = false;
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
    	if(word == null) return;
        Node cur = this.head;
        for(int i = 0; i < word.length(); i ++){
        	char c = word.charAt(i);
        	if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
        	cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	if(word == null) return false;
        Node cur = this.head;
        for(int i = 0; i < word.length(); i ++){
        	char c = word.charAt(i);
        	if(cur.children[c - 'a'] == null) return false;
        	cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if(prefix == null) return false;
    	Node cur = this.head;
        for(int i = 0; i < prefix.length(); i ++){
        	char c = prefix.charAt(i);
        	if(cur.children[c - 'a'] == null) return false;
        	cur = cur.children[c - 'a'];
        }
        return true;
    }
}
