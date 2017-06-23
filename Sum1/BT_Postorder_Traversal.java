package Sum1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BT_Postorder_Traversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> buff = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root == null) return buff;
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			buff.add(node.val);
			if(node.left != null) stack.push(node.left);
			if(node.right != null) stack.push(node.right);
		}
		List<Integer> res = new ArrayList<>();
		for(int i = buff.size() - 1; i >= 0; i --) res.add(buff.get(i));
		return res;
    }
}
