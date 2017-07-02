package Summer_All_Hard_Questions;

public class Recover_Binary_Search_Tree {
	//所以就是大的跑前面来了，小的跑后面去了
	TreeNode node1 = null;
	TreeNode node2 = null;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
		inOrderTraverse(root);
		if(node1 != null && node2 != null){
			int tmp = node1.val;
			node1.val = node2.val;
			node2.val = tmp;
		}
    }
	
	public void inOrderTraverse(TreeNode root){
		if(root == null) return;
		inOrderTraverse(root.left);
		if(node1 == null && root.val < prev.val){
			node1 = prev;
		}
		if(node1 != null && root.val < prev.val){
			node2 = root;
		}
		prev = root;
		inOrderTraverse(root.right);
	}
}
