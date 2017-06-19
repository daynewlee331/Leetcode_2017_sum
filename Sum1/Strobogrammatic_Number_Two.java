package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Strobogrammatic_Number_Two {
	public List<String> findStrobogrammatic(int n) {
		List<String> res = new ArrayList<>();
		getCombo(n / 2, n, "", "", res);
		return res;
    }
	
	public void getCombo(int k, int n, String cur1, String cur2, List<String> res){
		if(cur1.length() == k && cur2.length() == k) {
			if(n % 2 == 0) res.add(cur1 + cur2);
			else{
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
