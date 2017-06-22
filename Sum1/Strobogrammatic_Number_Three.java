package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Strobogrammatic_Number_Three {
	public int strobogrammaticInRange(String low, String high) {
		if(low == null || high == null) return 0;
		List<String> list = new ArrayList<>();
		for(int i = low.length(); i <= high.length(); i ++){
			getCombo(i / 2, i, "", "", list);
		}
		int res = 0;
		for(String s: list){
			if(s.length() == low.length() && s.compareTo(low) < 0) continue;
			if(s.length() == high.length() && s.compareTo(high) > 0) continue;
			res ++;
		}
		return res;
    }
	
	public void getCombo(int k, int n, String cur1, String cur2, List<String> res){
		if(cur1.length() == k && cur2.length() == k){
			if(n % 2 == 0){
				res.add(cur1 + cur2);
			}else{
				res.add(cur1 + '0' + cur2);
				res.add(cur1 + '1' + cur2);
				res.add(cur1 + '8' + cur2);
			}
			return;
		}
		if(!cur1.isEmpty()) getCombo(k, n, cur1 + '0', '0' + cur2, res);
		getCombo(k, n, cur1 + '1', '1' + cur2, res);
		getCombo(k, n, cur1 + '6', '9' + cur2, res);
		getCombo(k, n, cur1 + '8', '8' + cur2, res);
		getCombo(k, n, cur1 + '9', '6' + cur2, res);
	}
}
