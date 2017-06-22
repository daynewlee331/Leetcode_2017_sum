package Sum1;

public class First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
		if(nums.length < 1) return 1; 
		if(nums.length == 1 && nums[0] == 1) return 2;
        int i = 0, n = nums.length;
        while(i < n){
        		if(nums[i] > 0 && nums[i] <= n - 1 && i != nums[i] && nums[i] != nums[nums[i]]) swap(i, nums[i], nums);
        		else i ++;
        }
        int k = 1;
        while(k < n && k == nums[k]) {
        		k ++;
        }
        return nums[0] == k? k + 1: k;
    }
	
	public void swap(int i, int j, int[] nums){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
