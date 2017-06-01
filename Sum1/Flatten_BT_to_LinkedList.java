package Sum1;

public class Flatten_BT_to_LinkedList {
	TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(prev != null) {
            prev.left = null;
        	prev.right = root;
        }
        prev = root;
        flatten(left);
        flatten(right);
    }
}
