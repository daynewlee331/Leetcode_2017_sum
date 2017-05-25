package Sum1;

public class Power_of_Two {
	//Because the range of an integer = -2147483648 (-2^31) ~ 2147483647 (2^31-1)
	//the max possible power of two = 2^30 = 1073741824
	public boolean isPowerOfTwo(int n) {
		if(n == 0) return false;
        long num = 1;
        while(num < n){
        	num *= 2;
        }
        return num == (long)n;
    }
}
