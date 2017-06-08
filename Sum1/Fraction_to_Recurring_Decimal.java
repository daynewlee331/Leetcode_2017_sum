package Sum1;

import java.util.HashMap;

public class Fraction_to_Recurring_Decimal {
	public String fractionToDecimal(int numerator, int denominator) {
		long num = numerator, den = denominator;
        String res = "";
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) res += "-";
        num = Math.abs(num);
        den = Math.abs(den);
        res += num / den + "";
        num %= den;
        int pos = 0;
        StringBuilder frac = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while(num != 0){
        	num *= 10;
        	//long tmp = num / den;
        	if(map.containsKey(num)){
        		int beg = map.get(num);
        		String part1 = frac.substring(0, beg);
        		String part2 = frac.substring(beg);
        		return res + "." + part1 + "(" + part2 + ")";
        	}
        	frac.append(num / den);
        	map.put(num, pos);
        	num %= den;
        	pos ++;
        }
        return frac.length() == 0 ? res : res+"."+frac.toString();
    }
}
