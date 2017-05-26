package Sum1;


public class Find_Mode_in_BST {
	public int[] findMode(TreeNode root) {
		search(root);
		res = new int[index];
		index = 0;
		count = 0;
		search(root);
		return res;
    }
	
	int count = 0;
	int index = 0;
	int max = 0;
	Integer prev = null;
	int[] res = null;
	
	public void search(TreeNode root){
		if(root == null) return;
		search(root.left);
		if(prev == null || prev != root.val){
			count = 0;
			prev = root.val;
		}
		count ++;
		if(count == max) {
			if(res != null){
				res[index] = prev;
			}
			index ++;
		}else if(count > max){ //will never get into this loop in second call because max has been found
			max = count;
			index = 1;
		}
		search(root.right);
	}
}
