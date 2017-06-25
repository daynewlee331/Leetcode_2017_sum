package Sum1;

public class Construct_BT_from_Inorder_Postorder_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
	
	public TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd ) {
		if(inStart > inEnd || postStart > postEnd) return null;
		int rootVal = post[postEnd], rootIndex = 0;
		for(int i = inStart; i <= inEnd; i ++){
			if(in[i] == rootVal) {
				rootIndex = i;
				break;
			}
		}
		int len = rootIndex - inStart;
		TreeNode root = new TreeNode(rootVal);
		root.left = buildTree(in, inStart, rootIndex - 1, post, postStart, postStart + len - 1);
		root.right = buildTree(in, rootIndex + 1, inEnd, post, postStart + len, postEnd - 1);
		return root;
	}
}
