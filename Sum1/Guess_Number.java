package Sum1;

public class Guess_Number {
	public int guess(int x){
		return 10;
	}
	
	public int guessNumber(int n) {
        int i = 1, j = n;
        while(i < j){
            int mid = (j - i) / 2 + i;
            int ans = guess(mid);
            if(ans == -1){
                j = mid - 1;
            }else if(ans == 1){
                i = mid + 1;
            }else{
                return mid;
            }
        }
        return i;
    }
}
