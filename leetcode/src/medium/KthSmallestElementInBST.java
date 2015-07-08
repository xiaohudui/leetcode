package medium;

import java.util.Stack;

import util.TreeNode;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	int cnt=0;
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
    		cnt++;
    		if(cnt==k){
    			return node.val;
    		}
    		node=node.right;
    	}
    	return 0;
    }
}
