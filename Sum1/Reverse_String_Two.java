package Sum1;

public class Reverse_String_Two {
	public String reverseStr(String s, int k) {
        if(s == null || s.length() < 1 || k <= 0) return s;
        int index = 0, i = 0;
        char[] chars = s.toCharArray();
        while(index < chars.length){
        	if(index % 2 == 0){
        		if(i + k < chars.length) {
        			reverse(i, i + k - 1, chars);
        		}else{
        			reverse(i, chars.length - 1, chars);
        		}
        	}
        	i += k;
        	index ++;
        }
        return new String(chars);
    }
	
	public void reverse(int i, int j, char[] arr){
		while(i < j){
			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i ++; 
			j --;
		}
	}
}
