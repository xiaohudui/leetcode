package foundation.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class PreorderTraversal {
	/**
	 * 递归实现
	 */
	public List<Integer> recursiveTraversal(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
		visit(root,res);
		return res;
	}
	
	public void visit(TreeNode root,List<Integer> list){
		if(root==null){
			return;
		}
		list.add(root.val);
		visit(root.left,list);
		visit(root.right,list);
	}
	/**
	 * 非递归实现
	 */
	public List<Integer> traversal(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		if(root==null){
			return res;
		}
		TreeNode node=root;
		stack.push(node);
		while(!stack.empty()){
			node=stack.pop();
			res.add(node.val);
			if(node.right!=null){
				stack.push(node.right);
			}
			if(node.left!=null){
				stack.push(node.left);
			}
		}
		return res;
	}
}
