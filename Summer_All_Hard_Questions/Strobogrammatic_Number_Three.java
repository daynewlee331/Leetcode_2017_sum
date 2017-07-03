package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;

public class Strobogrammatic_Number_Three {
	public int strobogrammaticInRange(String low, String high) {
        if(low == null || low.isEmpty() || high == null || high.isEmpty()) return 0; 
        int res = 0;
        List<String> list = new ArrayList<>();
        for(int i = low.length(); i <= high.length(); i ++){
        		list.addAll(findStrobogrammatic(i));
        }
        for(String s: list){
        		if(s.length() == low.length() && s.compareTo(low) < 0) continue;
        		if(s.length() == high.length() && s.compareTo(high) > 0) continue;
        		res ++;
        }
        return res;
    }
	
	public List<String> findStrobogrammatic(int n) {
		List<String> res = new ArrayList<>();
        if(n < 1) return res;
        search("", "", n / 2, n, res);
        return res;
    }
	
	public void search(String cur1, String cur2, int m, int n, List<String> res){
		if(cur1.length() == m && cur2.length() == m){
			if(n % 2 == 0){
				res.add(cur1 + cur2);
			}else{
				res.add(cur1 + "0" + cur2);
				res.add(cur1 + "1" + cur2);
				res.add(cur1 + "8" + cur2);
			}
			return;
		}
		if(!cur1.isEmpty()) search(cur1 + "0", "0" + cur2, m, n, res);
		search(cur1 + "1", "1" + cur2, m, n, res);
		search(cur1 + "8", "8" + cur2, m, n, res);
		search(cur1 + "6", "9" + cur2, m, n, res);
		search(cur1 + "9", "6" + cur2, m, n, res);
	}
}
