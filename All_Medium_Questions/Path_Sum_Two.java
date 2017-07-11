package All_Medium_Questions;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_Two {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) return res;
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		search(root, list, sum - root.val, res);
		return res;
    }
	
	public void search(TreeNode root, List<Integer> list, int sum, List<List<Integer>> res){
		if(root.left == null && root.right == null && sum == 0) {
			 res.add(new ArrayList<>(list));
			 return;
		}
		if(root.left != null) {
			list.add(root.left.val);
			search(root.left, list, sum - root.left.val, res);
			list.remove(list.size() - 1);
		}
		
		if(root.right != null) {
			list.add(root.right.val);
			search(root.right, list, sum - root.right.val, res);
			list.remove(list.size() - 1);
		}
	}
}	
