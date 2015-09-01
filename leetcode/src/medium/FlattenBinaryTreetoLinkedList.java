package medium;

import java.util.Stack;

import util.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root==null){
        	return ;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        TreeNode pre=root;
        boolean firstRun=true;
        while(!stack.empty()){
        	TreeNode node=stack.pop();
        	if(node.right!=null){
        		stack.push(node.right);
        	}
        	if(node.left!=null){
        		stack.push(node.left);
        	}
        	if(!firstRun){
        		pre.left=null;
        		pre.right=node;
        		pre=node;
        	}
        	firstRun=false;
        }
    }
}
