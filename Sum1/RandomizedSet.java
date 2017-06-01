package Sum1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	Map<Integer, Integer> indexes = new HashMap<Integer, Integer>();
	Map<Integer, Integer> values = new HashMap<Integer, Integer>();
	private int index = 0;
	Random rand = null;
	/** Initialize your data structure here. */
    public RandomizedSet() {
    		this.rand = new Random();
        this.index = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    		if(values.containsKey(val)) return false;
        indexes.put(index, val);
        values.put(val, index);
    		index ++;
    		return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    		if(!values.containsKey(val)) return false;
        int delIndex = values.get(val);
        values.remove(val);
        if(delIndex == index - 1){
        		indexes.remove(index - 1);
        }else{
        		int lastElement = indexes.get(index - 1);
        		values.remove(lastElement);
        		indexes.remove(index - 1);
        		values.put(lastElement, delIndex);
        		indexes.put(delIndex, lastElement);
        }
        index --;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int target = this.rand.nextInt(index);
        return indexes.get(target);
    }
}
