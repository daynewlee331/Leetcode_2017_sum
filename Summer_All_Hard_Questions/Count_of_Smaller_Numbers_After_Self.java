package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;

public class Count_of_Smaller_Numbers_After_Self {
	class BSTNode{
		BSTNode left;
		BSTNode right;
		int count = 0;
		int val = 0;
		BSTNode(int x, int count){
			this.val = x;
			this.count = 0;
		}
	}
	
	private void add(BSTNode root, int val){
		if(root == null) return;
		if(val < root.val) {
			root.count ++;
			if(root.left == null) {
				root.left = new BSTNode(val, 0);
				return;
			}
			add(root.left, val);
		}else{
			if(root.right == null){
				root.right = new BSTNode(val, 0);
				return;
			}
			add(root.right, val);
		}
	}
	
	private int search(BSTNode root, int target){
		if(root.val == target) return root.count;
		if(target < root.val) return search(root.left, target);
		else return search(root.right, target);
	}
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums == null || nums.length < 1) return res;
		BSTNode root = new BSTNode(nums[0], 0);
		for(int i = 1; i < nums.length; i ++) add(root, nums[i]);
		for(int i = 0; i < nums.length; i ++) res.add(search(root, nums[i]));
		return res;
    }
}
