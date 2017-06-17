package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Count_Smaller_After_Self_BST {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		int count;
		TreeNode(int val){
			this.val = val;
			this.count = 0;
		}
	}
	
	public static void main(String[] args){
		Count_Smaller_After_Self_BST sol = new Count_Smaller_After_Self_BST();
		sol.countSmaller(new int[]{5,2,6,1});
	}
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length < 1) return res;
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		root.count = 1;
		List<Integer> buff = new ArrayList<>();
		buff.add(0);
		for(int i = nums.length - 2; i >= 0; i --){
			buff.add(get(root, nums[i], 0));
		}
		for(int i = nums.length - 1; i >= 0; i --){
			res.add(buff.get(i));
		}
		return res;
	}
	
	private int get(TreeNode root, int val, int num){
		if(root.val >= val){
			root.count ++;
			if(root.left == null){
				TreeNode node = new TreeNode(val);
				node.count = 1;
				root.left = node;
				return num;
			}else return get(root.left, val, num);
		}else{
			num += root.count;
			if(root.right == null){
				TreeNode node = new TreeNode(val);
				node.count = 1;
				root.right = node;
				return num;
			}else return get(root.right, val, num);
		}
	}
}
