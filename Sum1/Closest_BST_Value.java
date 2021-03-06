package Sum1;

public class Closest_BST_Value {
	public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root != null){
        		if(Math.abs(target - root.val) < Math.abs(target - res)) res = root.val;
        		root = target < root.val? root.left: root.right;
        }
        return res;
    }
}
