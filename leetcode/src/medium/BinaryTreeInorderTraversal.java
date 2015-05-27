package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeInorderTraversal {
	/**
	 * 树的中序遍历（非递归）
	 * 注意点：判栈为空的位置和先序不一样
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
        	return res;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node =root;
        while(true){
        	while(node!=null ){
        		stack.push(node);
        		node=node.left;
        	}
        	if(stack.isEmpty()){
        		break;
        	}
        	node=stack.pop();
        	res.add(node.val);
        	node=node.right;
        }
        return res;
    }
    /**
     * 树的中序遍历（递归） 
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
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
}
