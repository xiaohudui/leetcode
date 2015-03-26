package easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/same-tree/
 * 
 * @author xiaohu
 *
 */
public class SameTree {
	/**
	 * 思路一：（递归）根节点相同，左子树相同，右子树相同，即为同一棵树
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}
	/**
	 * 思路二：（非递归）采用前序遍历，也可用队列采用层序遍历，分别比较根及左右节点
	 * 思路三：可以分别把树先序和中序遍历到两个数组，浪费空间不采用
	 */
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
