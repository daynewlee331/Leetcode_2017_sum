package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Closest_K_Values_in_BST {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> order = new Stack<>();
		Stack<Integer> reverse = new Stack<>();
		inorder(root, target, order, false);
		inorder(root, target, reverse, true);
		while(k > 0){
			if(order.isEmpty()) res.add(reverse.pop());
			else if(reverse.isEmpty()) res.add(order.pop());
			else if(Math.abs(target - order.peek()) < Math.abs(reverse.peek() - target)) res.add(order.pop());
			else res.add(reverse.pop());
			k --;
		}
		return res;
    }
	
	public void inorder(TreeNode root, double target, Stack<Integer> stack, boolean reverse){
		if(root == null) return;
		inorder(!reverse? root.left: root.right, target, stack, reverse);
		if(!reverse && root.val > target) return;
		else if(reverse && root.val <= target) return;
		stack.push(root.val);
		inorder(!reverse? root.right: root.left, target, stack, reverse);
	}
}
