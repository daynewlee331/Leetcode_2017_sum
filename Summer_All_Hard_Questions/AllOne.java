package Summer_All_Hard_Questions;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class AllOne {
	class Node{
		Node prev;
		Node next;
		int val;
		LinkedHashSet<String> elements = null;
		public Node(int x){
			val = x;
			elements = new LinkedHashSet<>();
		}
	}
	
	private Node head = null;
	private Map<String, Node> keys = null;
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(-999);
        head.next = head;
        head.prev = head;
        keys = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(keys.containsKey(key)){
        		Node cur = keys.get(key);
        		if(cur.next.val != cur.val + 1){
        			insert(cur, new Node(cur.val + 1));
        		}
        		keys.put(key, cur.next);
        		cur.next.elements.add(key);
        		cur.elements.remove(key);
        		if(cur.elements.isEmpty()) delete(cur);
        }else{
        		if(head.next.val != 1){
        			insert(head, new Node(1));
        		}
        		keys.put(key, head.next);
        		head.next.elements.add(key);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!keys.containsKey(key)) return;
        Node cur = keys.get(key);
        if(cur.val == 1) {
        		cur.elements.remove(key);
        		keys.remove(key);
        		if(cur.elements.isEmpty()) delete(cur);
        		return;
        }
        if(cur.prev.val != cur.val - 1){
        		insert(cur.prev, new Node(cur.val - 1));
        }
        keys.put(key, cur.prev);
        cur.prev.elements.remove(key);
        cur.next.elements.add(key);
        if(cur.elements.isEmpty()) delete(cur);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Node cur = head.prev;
        if(cur.equals(head)) return null;
        return cur.elements.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
    		Node cur = head.next;
        if(cur.equals(head)) return null;
        return cur.elements.iterator().next();
    }
    
    private void insert(Node cur, Node newNode){
    		Node next = cur.next;
    		cur.next = newNode;
    		newNode.next = next;
    		next.prev = newNode;
    		newNode.prev = cur;
    }
    
    private void delete(Node node){
    		Node prev = node.prev;
    		Node next = node.next;
    		prev.next = next;
    		next.prev = prev;
    }
}
