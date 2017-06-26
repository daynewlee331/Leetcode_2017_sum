package Summer_All_Hard_Questions;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LFUCache {
	class Node{
		Node next;
		Node prev;
		int count = 0;
		LinkedHashMap<Integer, Integer> elements;
		public Node(int x){
			this.elements = new LinkedHashMap<>();
			this.count = x;
		}
	}
	HashMap<Integer, Node> map = null;
	Node head = null;
	int limit = 0;
	
	public LFUCache(int capacity) {
		if(capacity == 0) return;
        map = new HashMap<>();
        head = new Node(-999);
        head.next = head;
        head.prev = head;
        this.limit = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        int val = cur.elements.get(key);
        Node next = null;
        if(cur.next.count != cur.count + 1){
        		next = new Node(cur.count + 1);
        		insertNode(cur, next);
        }else next = cur.next;
        next.elements.put(key, val);
        cur.elements.remove(key);
        if(cur.elements.size() == 0) deleteNode(cur);
        map.put(key, next);
        return val;
    }
    
    public void put(int key, int value) {
    		if(this.limit <= 0) return;
        if(map.containsKey(key)){
        		get(key);
        		map.get(key).elements.put(key, value);
        		return;
        }
        //first delete LF element
        if(map.size() >= this.limit){
        		int toDelKey = head.next.elements.keySet().iterator().next();
        		map.remove(toDelKey);
        		head.next.elements.remove(toDelKey);
        		if(head.next.elements.isEmpty()) deleteNode(head.next);
        }
        if(head.next.count != 1){
        		Node node = new Node(1);
        		insertNode(head, node);
        }
        head.next.elements.put(key, value);
        map.put(key, head.next);
    }
    
    private void deleteNode(Node node){
    		Node prev = node.prev;
    		Node next = node.next;
    		prev.next = next;
    		next.prev = prev;
    }
    
    private void insertNode(Node cur, Node newElement){
    		Node next = cur.next;
    		cur.next = newElement;
    		newElement.next = next;
    		next.prev = newElement;
    		newElement.prev = cur;
    }
}
