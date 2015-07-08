package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class InOrder {
	public List<Integer> traverse(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		dfs(root, ret);
		return ret;
	}
	/**
	 * 递归实现中序
	 */
	public void dfs(TreeNode root, List<Integer> ret) {
		if (root == null) {
			return;
		}
		dfs(root.left, ret);
		ret.add(root.val);
		dfs(root.right, ret);
	}
	/**
	 * 中序遍历非递归实现
	 */
	public void inOrder(TreeNode root){
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode node=root;
		while(true){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			if(stack.empty()){
				break;
			}
			node=stack.pop();
			System.out.println(node.val);
			node=node.right;
		}
	}
}
