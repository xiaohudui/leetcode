package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res=new ArrayList<Integer>();
    	if(root==null){
    		return res;
    	}
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode node=stack.pop();
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
    public List<Integer> recursive_preorderTraversal(TreeNode root) {
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
}
