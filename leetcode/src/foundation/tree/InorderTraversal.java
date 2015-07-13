package foundation.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class InorderTraversal {
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
		visit(root.left,list);
		list.add(root.val);
		visit(root.right,list);
	}
	/**
	 * 非递归实现
	 */
	public List<Integer> traversal(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
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
			res.add(node.val);
			node=node.right;
		}
		return res;
	}
}
