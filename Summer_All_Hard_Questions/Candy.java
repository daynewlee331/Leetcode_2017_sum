package Summer_All_Hard_Questions;

public class Candy {
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1) return 0;
        int[] candies = new int[ratings.length];
        for(int i = 0; i < candies.length; i ++) candies[i] = 1;
        for(int j = 0; j + 1 < ratings.length; j ++){
        		if(ratings[j] < ratings[j + 1]) candies[j + 1] = candies[j] + 1;
        }
        for(int k = ratings.length - 1; k - 1 >= 0; k --){
        		if(ratings[k - 1] > ratings[k]) candies[k - 1] = Math.max(candies[k - 1], candies[k] + 1);
        }
        int sum = 0;
        for(int i = 0; i < candies.length; i ++) sum += candies[i];
        return sum;
    }
}	
