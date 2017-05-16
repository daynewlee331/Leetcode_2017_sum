package Sum1;


public class Min_Diff_BST {
	int min = Integer.MAX_VALUE;
	Integer prev = null;
	public int getMinimumDifference(TreeNode root) {
		helper(root);
		return min;
    }
	
	public void helper(TreeNode root){
		if(root == null) return;
		helper(root.left);
		if(prev != null) min = Math.min(Math.abs(root.val - prev), min);
		prev = root.val;
		helper(root.right);
	}
}
