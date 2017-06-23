package Sum1;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SummaryRanges {
	TreeMap<Integer, Interval> map = null;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.map = new TreeMap<>();
    }
    
    public void addNum(int val) {
    	if(map.containsKey(val)) return;
        Integer l = map.lowerKey(val), h = map.higherKey(val);
        if(l != null && h != null && map.get(l).end == val - 1 && h == val + 1){
        	map.get(l).end = map.get(h).end;
        	map.remove(h);
        }else if(l != null && map.get(l).end + 1 >= val){//val might be higher than existing interval
        	map.get(l).end = Math.max(map.get(l).end, val);
        }else if(h != null && h == val + 1){
        	map.put(val, new Interval(val, map.get(h).end));
        	map.remove(h);
        }
        else map.put(val, new Interval(val, val));
        
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}
