package Sum1;

public class Flatten_BT_to_LinkedList {
	TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode tmp1 = root.left;
        TreeNode tmp2 = root.right;
        if(prev != null) {
            prev.left = null;
        	prev.right = root;
        }
        prev = root;
        flatten(tmp1);
        flatten(tmp2);
    }
}
