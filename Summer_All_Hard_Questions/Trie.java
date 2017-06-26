package Summer_All_Hard_Questions;

public class Trie {
	class Node{
		Node[] childiren = null;
		boolean isWord = false;
		Node(){
			this.isWord = false;
			this.childiren = new Node[26];
		}
	}
	
	Node root = null;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = this.root;
        for(char c: word.toCharArray()){
        		if(cur.childiren[c - 'a'] == null) cur.childiren[c - 'a'] = new Node();
        		cur = cur.childiren[c - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    		Node cur = this.root;
        for(char c: word.toCharArray()){
        		if(cur.childiren[c - 'a'] == null) return false;
        		cur = cur.childiren[c - 'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Node cur = this.root;
        for(char c: prefix.toCharArray()){
        		if(cur.childiren[c - 'a'] == null) return false;
        		cur = cur.childiren[c - 'a'];
        }
        return true;
    }
}
