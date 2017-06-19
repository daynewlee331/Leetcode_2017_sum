package Sum1;

public class Sqrt_X {
	public int mySqrt(int x) {
        if(x == 1 || x == 0) return x;
        long low = 1, hi = x/2;
        while(low <= hi){
        		long mid = (hi - low) / 2 + low;
        		if(mid * mid <= x && (mid + 1) * (mid + 1) > x) return (int)mid;
        		else if(mid * mid < x) low = mid + 1;
        		else hi = mid - 1;
        }
        return -1;
    }
}
