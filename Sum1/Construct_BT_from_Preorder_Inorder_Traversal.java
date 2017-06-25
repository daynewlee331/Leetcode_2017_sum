package Sum1;

public class Construct_BT_from_Preorder_Inorder_Traversal {
	//http://www.cnblogs.com/springfor/p/3884034.html
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1) return null;
        return Construct_BT(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
	
	public TreeNode Construct_BT(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
		if(preStart > preEnd || inStart > inEnd) return null;
		int rootVal = pre[preStart];
		int rootIndex = 0;
		for(int i = inStart; i <= inEnd; i ++){
			if(in[i] == rootVal) {
				rootIndex = i;
				break;
			}
		}
		TreeNode root = new TreeNode(rootVal);
		int len = rootIndex - inStart;
		root.left = Construct_BT(pre, preStart + 1, preStart + len, in, inStart, rootIndex - 1);
		root.right = Construct_BT(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);
		return root;
	}
}
