package easy;
import java.util.Stack;

import util.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && sum == root.val) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	public boolean hasPathSum1(TreeNode root, int sum) {
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Stack<Integer> sums=new Stack<Integer>();
		if (root != null) {
			nodes.push(root);
			sums.push(root.val);
			while (!nodes.isEmpty()) {
				TreeNode node = nodes.pop();
				int sumValue=sums.pop();
				if(node.left==null && node.right==null && sum==sumValue){
					return true;
				}
				if(node.left!=null){
					nodes.push(node.left);
					sums.push(sumValue+node.left.val);
				}
				if(node.right!=null){
					nodes.push(node.right);
					sums.push(sumValue+node.right.val);
				}
			}
		}
		return false;
	}
}
