package easy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
	}
	public int minDepth1(TreeNode root){
		Stack<TreeNode> nodes=new Stack<TreeNode>();
		Stack<Integer> depths=new Stack<Integer>();
		List<Integer> list=new ArrayList<Integer>();
		if(root==null){
			return 0;
		}
		nodes.push(root);
		depths.push(0);
		while(!nodes.isEmpty()){
			TreeNode node=nodes.pop();
			int depth=depths.pop();
			if(node.left==null && node.right==null){
				list.add(depth+1);
			}
			if(node.left!=null){
				nodes.push(node.left);
				depths.push(depth+1);
			}
			if(node.right!=null){
				nodes.push(node.right);
				depths.push(depth+1);
			}
		}
		return Collections.min(list);
	}
	public int minDepth2(TreeNode root){
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		int curNum=0;
		int lastNum=1;
		int depth=1;
		if(root==null){
			return 0;
		}
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
			if(node.left==null && node.right==null){
				return depth;
			}
			lastNum--;
			if(node.left !=null){
				queue.offer(node.left);
				curNum++;
			}
			if(node.right!=null){
				queue.offer(node.right);
				curNum++;
			}
			if(lastNum==0){
				lastNum=curNum;
				curNum=0;
				depth++;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		
	}
}
