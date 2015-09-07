package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null){
			return res;
		}
		boolean reverseFlag=false;
		Stack<TreeNode> currLevel=new Stack<TreeNode>();
		Stack<TreeNode> nextLevel=new Stack<TreeNode>();
		currLevel.push(root);
		while(!currLevel.empty()){
			List<Integer> list=new ArrayList<Integer>();
			while(!currLevel.empty()){
				TreeNode node=currLevel.pop();
				list.add(node.val);
				if(!reverseFlag){
					if(node.left!=null){
						nextLevel.push(node.left);
					}
					if(node.right!=null){
						nextLevel.push(node.right);
					}
				}else{
					if(node.right!=null){
						nextLevel.push(node.right);
					}
					if(node.left!=null){
						nextLevel.push(node.left);
					}
				}
			}
			reverseFlag=!reverseFlag;
			res.add(list);
			Stack<TreeNode> temp=currLevel;
			currLevel=nextLevel;
			nextLevel=temp;
		}
		return res;
	}
}
