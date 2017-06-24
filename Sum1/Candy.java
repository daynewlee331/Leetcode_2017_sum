package Sum1;

public class Candy {
	//https://discuss.leetcode.com/topic/25985/simple-o-n-java-solution-with-comments
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1) return 0;
        int[] candies = new int[ratings.length];
        for(int i = 0; i < candies.length; i ++) candies[i] = 1;
        for(int i = 0; i + 1 < candies.length; i ++) {
        		if(ratings[i + 1] > ratings[i]) candies[i + 1] = candies[i] + 1;
        }
        for(int j = candies.length - 1; j >= 1; j ++){
        		if(ratings[j - 1] > ratings[j]) candies[j - 1] = candies[j] + 1;
        }
        int res = 0;
        for(int num: candies) res += num;
        return res;
    }
}
