package Sum1;

public class Magical_String {
	public int magicalString(int n) {
        StringBuilder magic = new StringBuilder("1221121221221121122");
        int p1 = 12, p2 = magic.length(), count = 0;
        while(magic.length() < n){
        		if(magic.charAt(p1) == '1'){
        			if(magic.charAt(p2 - 1) == '1') {
        				magic.append('2');
        			}else{
        				magic.append('1');
        			}
        			p2 ++;
        		}else{
        			if(magic.charAt(p2 - 1) == '1') {
        				magic.append("22");
        			}else{
        				magic.append("11");
        			}
        			p2 += 2;
        		}
        		p1 ++;
        }
        for(int i = 0; i < n; i ++){
        		if(magic.charAt(i) == '1') count ++;
        }
        return count;
    }
}
