package easy;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left == null || root.right == null) {
			return false;
		}
		return isSameTree(root.left, root.right);
	}

	public boolean isSameTree(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null || left.val != right.val) {
			return false;
		}
		return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
	}

	public boolean isSymmetricTree(TreeNode t1, TreeNode t2) {
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(t1);
		q2.offer(t2);
		while (!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode node1 = q1.poll();
			TreeNode node2 = q2.poll();
			if (node1 != null && node2 != null && node1.val != node2.val) {
				return false;
			}
			if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
				return false;
			}
			if (node1 != null && node2 != null && node1.val == node2.val) {
				q1.offer(node1.left);
				q1.offer(node1.right);
				q2.offer(node2.right);
				q2.offer(node2.left);
			}
		}
		return q1.isEmpty() && q2.isEmpty();
	}
}
