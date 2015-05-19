package medium;

import java.util.Stack;

import util.TreeNode;
/**
 * 思路一：中序遍历，将节点全部放入list中
 * 时间O(1),空间O(n)
 * 思路二：采用栈存储，每次出栈，如果含有右孩子，将所有右孩子的左孩子入栈
 * 实现了空间O(h)，没有实现时间O(1)
 *
 */
public class BSTIterator {

	Stack<TreeNode> stack=new Stack<TreeNode>();
	public BSTIterator(TreeNode root) {
		while(root!=null){
			stack.push(root);
			root=root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode res=stack.pop();
		TreeNode right=res.right;
		while(right!=null){
			stack.push(right);
			right=right.left;
		}
		return res.val;
	}
}