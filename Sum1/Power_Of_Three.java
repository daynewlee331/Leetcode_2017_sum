package Sum1;

public class Power_Of_Three {
	public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        return n > 0 && 1162261467 % n == 0;
    }
}
