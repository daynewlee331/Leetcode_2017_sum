package Summer_All_Hard_Questions;

import java.util.LinkedHashMap;

public class LRUCache {
	private LinkedHashMap<Integer, Integer> map = null;
	private int limit = 0;
	
	public LRUCache(int capacity) {
		map = new LinkedHashMap<>();
		this.limit = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = this.map.get(key);
        this.map.remove(key);
        this.map.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)){
        		this.map.remove(key);
        		this.map.put(key, value);
        		return;
        }
        if(this.map.size() < this.limit) this.map.put(key, value);
        else{
        		int toDelKey = this.map.keySet().iterator().next();
        		map.remove(toDelKey);
        		map.put(key, value);
        }
    }
}
