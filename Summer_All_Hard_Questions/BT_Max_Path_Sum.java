package Summer_All_Hard_Questions;

public class BT_Max_Path_Sum {
	private int[] max = new int[1];
	public int maxPathSum(TreeNode root) {
		max[0] = Integer.MIN_VALUE;
		int sum = search(root);
		max[0] = Math.max(max[0], sum);
		return max[0];
    }
	
	public int search(TreeNode root){
		if(root == null) return 0;
		int left = Math.max(0, search(root.left));
		int right = Math.max(0,search(root.right));
		int total = root.val + left + right;
		max[0] = Math.max(max[0], total);
		return Math.max(left, right) + root.val;
	}
}
