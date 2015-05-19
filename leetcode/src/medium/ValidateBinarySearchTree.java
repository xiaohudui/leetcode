package medium;

import java.util.Stack;

import util.TreeNode;

public class ValidateBinarySearchTree {
	/**
	 * 递归解法:判断每一个节点是否满足大于左子树上的所有值，小于右子树上的所有值
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidLeft(root.left, root.val) || !isValidRight(root.right, root.val)) {
			return false;
		} else if (isValidBST(root.left) && isValidBST(root.right)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isValidLeft(TreeNode root, int val) {
		if (root == null) {
			return true;
		}
		if (root.val >= val && isValidLeft(root.left, val) && isValidLeft(root.right, val)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isValidRight(TreeNode root, int val) {
		if (root == null) {
			return true;
		}
		if (root.val <= val && isValidRight(root.left, val) && isValidRight(root.right, val)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 思路二：判断是否中序有序 树的中序遍历：左中右
	 */
	public boolean isValidBST1(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = root.left;
		TreeNode pre = null;
		while (true) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if(stack.isEmpty()){
				break;
			}
			cur = stack.pop();
			if (pre != null && pre.val >= cur.val) {
				return false;
			}
			pre=cur;
			cur = cur.right;
		}
		return true;
	}
	/**
	 * 给出每一个节点的最大值和最小值
	 * 对每一个节点，父节点规定了左子树的最大值，且继承了父节点的最小值
	 * 对每一个节点，父节点规定了右子树的最小值，且继承了父节点的最大值
	 */
	public boolean isValidBST2(TreeNode root) {
		if(root==null){
			return true;
		}
		return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	public boolean dfs(TreeNode root,long min,long max){
		if(root==null){
			return true;
		}
		if(root.val>=max || root.val<=min){
			return false;
		}
		return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);
	}
}
