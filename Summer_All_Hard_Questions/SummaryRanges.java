package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SummaryRanges {
	/** Initialize your data structure here. */
	private TreeMap<Integer, Interval> map = null;
    public SummaryRanges() {
    	map = new TreeMap<>();
    }
    //左近邻元素floor（start值不大于val的最大Interval），以及右近邻元素higher（start值严格大于val的最小Interval）
    public void addNum(int val) {
        if(map.containsKey(val)) return;
        Integer lower = map.lowerKey(val), higher = map.higherKey(val);
        if(lower != null && higher != null && map.get(lower).end == val - 1 && higher == val + 1){
        	map.get(lower).end = map.get(higher).end;
        	map.remove(higher);
        }else if(lower != null && map.get(lower).end + 1 >= val){
        	map.get(lower).end = Math.max(map.get(lower).end, val);
        }else if(higher != null && higher == val + 1){
        	map.put(val, new Interval(val, map.get(higher).end));
        	map.remove(higher);
        }else map.put(val, new Interval(val, val));
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(map.values());
    }
}
