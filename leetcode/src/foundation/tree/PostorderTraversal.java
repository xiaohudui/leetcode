package foundation.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class PostorderTraversal {
	/**
	 * 递归实现
	 */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        visit(root,res);
        return res;
    }
    public void visit(TreeNode root,List<Integer> list){
    	if(root==null){
    		return;
    	}
    	visit(root.left,list);
    	visit(root.right,list);
    	list.add(root.val);
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
    	TreeNode pre=null;
    	stack.push(node);
    	while(!stack.empty()){
    		node=stack.peek();
    		if((node.left==null && node.right==null) ||(pre!=null && (pre==node.left||pre==node.right))){
    			res.add(node.val);
    			stack.pop();
    			pre=node;
    		}else{
    		    if(node.right!=null){
    			    stack.push(node.right);
    		    }   
    		    if(node.left!=null){
    			    stack.push(node.left);
    		    }
    		}
    	}
    	return res;
    }
}
