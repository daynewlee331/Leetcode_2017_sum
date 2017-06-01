package Sum1;

import java.util.ArrayList;
import java.util.List;

public class Boundary_of_BT {
	//0 - root, 1 - left boundary node, 2 - right boundary node, 3 - middle node
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left = new ArrayList<Integer>(), right = new ArrayList<Integer>();
        preorderSearch(root, left, right, 0);
        left.addAll(right);
        return left;
    }
	
	public void preorderSearch(TreeNode root, List<Integer> left, List<Integer> right, int flag){
		if(root == null) return;
		if(flag == 2) right.add(0, root.val);
		else if(flag <= 1 || (root.left == null && root.right == null)) left.add(root.val);
		preorderSearch(root.left, left, right, flag <= 1? 1 : (flag == 2 && root.right == null)? 2 : 3);
		preorderSearch(root.right, left, right, flag % 2 == 0? 2: (flag == 1 && root.left == null)? 1: 3);
	}
}
