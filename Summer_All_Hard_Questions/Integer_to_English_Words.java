package Summer_All_Hard_Questions;

import java.util.Stack;

public class Integer_to_English_Words {
	String[] Teens = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", 
			"Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
			"Seventeen", "Eighteen", "Nineteen"};
	String[] Tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String[] Hundreds = {"", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred",
							"Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"};
	String[] Thousands = {"", "", "Thousand", "Million", "Billion"};
	
	public static void main(String[] args){
		Integer_to_English_Words sol = new Integer_to_English_Words();
		sol.numberToWords(100);
	}
	
	public String numberToWords(int num) {
        if(num == 0) return "Zero";
        Stack<String> stack = new Stack<>();
        while(num != 0){
        	int n = num % 1000;
        	if(n == 0){
        		stack.push("*");
        	}else{
        		stack.push(getThreeDigits(n));
        	}
        	num = num / 1000;
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
        	int k = stack.size();
        	String numStr = stack.pop();
        	if(!numStr.equals("*")){
        		builder.append(numStr);
        		builder.append(" ");
        		builder.append(Thousands[k]);
        		builder.append(" ");
        	}
        }
        String res = builder.toString().trim();
        return res;
    }
	
	public String getThreeDigits(int num){
		if(num < 100) return getTwoDigits(num);
		return num % 100 != 0? Hundreds[num / 100] + " " + getTwoDigits(num % 100) : Hundreds[num / 100];
	}
	
	public String getTwoDigits(int num){
		if(num <= 19) return Teens[num];
		return num % 10 != 0? Tens[num / 10] + " " + Teens[num % 10] : Tens[num / 10];
	}
}
