package easy;

import java.util.Stack;

import util.TreeNode;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p != null && q != null && p.val == q.val) {
			Stack<TreeNode> t1 = new Stack<TreeNode>();
			Stack<TreeNode> t2 = new Stack<TreeNode>();
			t1.push(p);
			t2.push(q);
			while (!t1.isEmpty() && !t2.isEmpty()) {
				TreeNode node1 = t1.pop();
				TreeNode node2 = t2.pop();
				if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
					return false;
				} else if (node1 != null && node2 != null && node1.val == node2.val) {
					t1.push(node1.left);
					t1.push(node1.right);
					t2.push(node2.left);
					t2.push(node2.right);
				} else if (node1 != null && node2 != null && node1.val != node2.val) {
					return false;
				}
			}
			return t1.isEmpty() && t2.isEmpty();
		} else {
			return false;
		}
	}
}
