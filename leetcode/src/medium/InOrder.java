package medium;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class InOrder {
	public List<Integer> traverse(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		dfs(root, ret);
		return ret;
	}
	/**
	 * 递归实现先序
	 */
	public void dfs(TreeNode root, List<Integer> ret) {
		if (root == null) {
			return;
		}
		dfs(root.left, ret);
		ret.add(root.val);
		dfs(root.right, ret);
	}
}
