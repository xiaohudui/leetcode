package medium;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class UniqueBinarySearchTreeII {
	public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	public List<TreeNode> helper(int m, int n) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (n < m) {
			res.add(null);
			return res;
		}
		List<TreeNode> left = new ArrayList<TreeNode>();
		List<TreeNode> right = new ArrayList<TreeNode>();
		for (int i = m; i <= n; i++) {
			left = helper(m, i - 1);
			right = helper(i + 1, n);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}
