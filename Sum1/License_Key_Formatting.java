package Sum1;

public class License_Key_Formatting {
	public String licenseKeyFormatting(String S, int K) {
		char[] chars = S.toCharArray();
        StringBuilder res = new StringBuilder();
        int count = 0;
        for(int i = chars.length - 1; i >= 0; i --){
        		char c = S.charAt(i);
        		if(c == '-') continue;
        		res.append(c);
        		count ++;
        		if(count == K){
        			count = 0;
        			res.append('-');
        		}
        }
        res = res.reverse();
        if(res.length() > 1 && res.charAt(0) == '-') res.deleteCharAt(0);
        return res.toString().toUpperCase();
    }
}
