package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(numRows < 1) return res;
		List<Integer> prev = null;
		for(int i = 1; i <= numRows; i ++){
			List<Integer> sub = new ArrayList<Integer>();
			for(int j = 0; j < i; j ++){
				if(j == 0 || j == i - 1) sub.add(1);
				else {
					int num = prev.get(j - 1) + prev.get(j);
					sub.add(num);
				}
			}
			res.add(sub);
			prev = sub;
		}
		return res;
    }
}
