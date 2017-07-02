package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Rearrange_String_k_Distance_Apart {
	public String rearrangeString(String s, int k) {
        if(s.length() <= 1 || k < 1) return s;
        HashMap<Character, Element> map = new HashMap<>();
        for(char c: s.toCharArray()){
        		if(!map.containsKey(c)) map.put(c, new Element(1, c));
        		else{
        			map.get(c).count ++;
        		}
        }
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){
			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				if(o1.count != o2.count) return o2.count - o1.count;
				else return o1.c - o2.c;
			}
        });
        pq.addAll(map.values());
        StringBuilder builder = new StringBuilder();
        while(!pq.isEmpty()){
        		List<Element> buffer = new ArrayList<>();
        		int n = 0;
        		while(n < k){
        			if(pq.isEmpty()) return "";
        			Element e = pq.poll();
        			builder.append(e.c);
        			e.count --;
        			if(e.count > 0) buffer.add(e);
                    if(builder.length() == s.length()) return builder.toString();
        			n ++;
        		}
        		pq.addAll(buffer);
        }
        return builder.toString();
    }
	
	class Element {
		int count = 0;
		char c;
		public Element(int x, char ch){
			this.count = x;
			this.c = ch;
		}
	}
}
