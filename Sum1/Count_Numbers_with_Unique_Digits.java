package Sum1;


public class Count_Numbers_with_Unique_Digits {
	public int countNumbersWithUniqueDigits(int n) {
		if(n <= 0) return 1;
		if(n == 1) return 10;
		if(n > 10) n = 10;
		int res = 0;
		res += 10 + 9 * 9;
		int prev = 9 * 9;
		for(int k = 3; k <= n; k ++){
			int num = prev * (11 - k);
			res += num;
			prev = num;
		}
        return res;
    }
	
}
