package foundation.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class LevelOrderTraversal {
	/**
	 * 非递归实现方式
	 */
    public List<List<Integer>> recursiveTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		int cnt1 = 1, cnt2 = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			cnt1--;
			list.add(t.val);
			if (t.left != null) {
				queue.offer(t.left);
				cnt2++;
			}
			if (t.right != null) {
				queue.offer(t.right);
				cnt2++;
			}
			if (cnt1 == 0) {
				cnt1 = cnt2;
				cnt2 = 0;
				res.add(list);
				list = new ArrayList<Integer>();
			}
		}
		return res;
    }
    /**
     * 递归方式实现
     */
    public List<List<Integer>> traversal(TreeNode root) {
    	int level=maxLevel(root);
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	List<Integer> list;
    	for (int i = 0; i < level; i++) {
			list=new ArrayList<Integer>();
			visitLevel(root, i, list);
			res.add(list);
		}
    	return res;
    }
    public int maxLevel(TreeNode root){
    	if(root==null){
    		return 0;
    	}
    	return 1+Math.max(maxLevel(root.left), maxLevel(root.right));
    }
    public void visitLevel(TreeNode root,int level,List<Integer> list){
    	if(root==null){
    		return;
    	}
    	if(level==0){
    		list.add(root.val);
    	}else{
    		visitLevel(root.left, level-1, list);
    		visitLevel(root.right, level-1, list);
    	}
    }
}
