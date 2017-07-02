package Summer_All_Hard_Questions;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_Deserialize_BT {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	for(int i = 0; i < size; i ++){
        		TreeNode cur = queue.poll();
        		if(cur != null) builder.append(cur.val);
        		else builder.append("#");
        		builder.append(",");
        		queue.offer(cur.left);
        		queue.offer(cur.right);
        	}
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        TreeNode[] nodes = new TreeNode[vals.length];
        for(int i = 0; i < vals.length; i ++){
        	if(vals[i].equals("#")) nodes[i] = null;
        	else if(!vals[i].equals("")) nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
        }
        int k = 0;
        for(int i = 0; i < nodes.length; i ++){
        	if(nodes[i] == null) k ++;
        	else {
        		if(2 * (i - k) + 1 < nodes.length) nodes[i].left = nodes[2 * (i - k) + 1];
        		if(2 * (i - k) + 2 < nodes.length) nodes[i].right = nodes[2 * (i - k) + 2];
        	}
        }
        return nodes[0];
    }
}
