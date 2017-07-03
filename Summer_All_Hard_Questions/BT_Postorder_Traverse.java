package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BT_Postorder_Traverse {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> vals = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			vals.push(cur.val);
			if(cur.left != null) stack.push(cur.left);
			if(cur.right != null) stack.push(cur.right);
		}
		while(!vals.isEmpty()) res.add(vals.pop());
		return res;
    }
}
