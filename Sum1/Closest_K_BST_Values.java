package Sum1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Closest_K_BST_Values {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> order = new Stack<>();
		Stack<Integer> reverse = new Stack<>();
		inOrderTraverse(root, target, false, order);
		inOrderTraverse(root, target, true, reverse);
		while(k > 0){
			if(order.isEmpty()) res.add(reverse.pop());
			else if(reverse.isEmpty()) res.add(order.pop());
			else if(Math.abs(order.peek() - target) < Math.abs(reverse.peek() - target)) res.add(order.pop());
			else res.add(reverse.pop());
			k --;
		}
		return res;
    }
	
	public void inOrderTraverse(TreeNode root, double target, boolean reverse, Stack<Integer> stack){
		if(root == null) return;
		inOrderTraverse(reverse? root.right: root.left, target, reverse, stack);
		if(!reverse && root.val > target) return;
		else if(reverse && root.val <= target) return;
		stack.push(root.val);
		inOrderTraverse(reverse? root.left: root.right, target, reverse, stack);
	}
}
