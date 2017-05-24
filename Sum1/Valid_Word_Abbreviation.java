package Sum1;

public class Valid_Word_Abbreviation {
	public static void main(String[] args){
		Valid_Word_Abbreviation sol = new Valid_Word_Abbreviation();
		boolean test1 = sol.validWordAbbreviation("internationalization", "i12iz4n");
		System.out.println(test1);
		boolean test2 = sol.validWordAbbreviation("abbreviation", "a10n");
		System.out.println(test2);
		boolean test3 = sol.validWordAbbreviation("word", "w3");
		System.out.println(test3);
		boolean test4 = sol.validWordAbbreviation("word", "11rd");
		System.out.println(test4);
	}
	
	public boolean validWordAbbreviation(String word, String abbr) {
		if(abbr.length() > word.length()) return false;
        int index = 0, i = 0;
        while(i < abbr.length()){
        		char c = abbr.charAt(i);
        		if(index >= word.length()) return false;
        		if(c >= '0' && c <= '9'){
        			StringBuilder sb = new StringBuilder();
        			while(i < abbr.length() && (abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9')) {
        				sb.append(abbr.charAt(i));
        				i ++;
        			}
        			if(sb.charAt(0) == '0') return false;
        			index += Integer.parseInt(sb.toString());
        		}else if(c >= 'a' && c <= 'z') {
        			if(c != word.charAt(index ++)) return false;
        			i ++;
        		}else return false;
        }
        if(index == word.length()) return true;
        return false;
    }
}
