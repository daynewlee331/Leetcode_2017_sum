package Summer_All_Hard_Questions;

public class First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
        if(nums.length < 1) return 1;
        if(nums.length == 1 && nums[0] != 1) return 1;
        int n = nums.length;
        int j = 0;
        while(j < n){
        		if(nums[j] >= 1 && nums[j] < n && j != nums[j] && nums[j] != nums[nums[j]]) swap(j, nums[j], nums);
        		else j ++;
        }
        int k = 1;
        for(; k < n; k ++){
        		if(k != nums[k]) return k;
        }
        return nums[0] == k? k + 1 : k;
    }
	
	private void swap(int i, int j, int[] arr){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
