package Sum1;

public class Decode_Ways {
	public static void main(String[] args){
		Decode_Ways sol = new Decode_Ways();
		int num = sol.numDecodings("10");
		System.out.println(num);
	}
	
	public int numDecodings(String s) {
		if(s == null || s.length() < 1) return 0;
        int[] dp = new int[s.length() + 1];
        if(s.charAt(0) == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= s.length(); i ++){
        		int num = Integer.parseInt(s.charAt(i - 1) + "" + s.charAt(i));
        		if(num >= 10 && num <= 26){
        			dp[i] += dp[i - 2];
        		}
        		if(s.charAt(i) >= '1' && s.charAt(i) <= '9'){
        			dp[i] += dp[i - 1];
        		}
        }
        return dp[s.length()];
    }
}
