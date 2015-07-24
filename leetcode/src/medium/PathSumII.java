package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Stack<List<Integer>> paths = new Stack<List<Integer>>();
		if (root == null) {
			return res;
		}
		nodes.push(root);
		List<Integer> list=new ArrayList<Integer>();
		list.add(root.val);
		paths.push(list);
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.pop();
			list=paths.pop();
			if (node.left == null && node.right == null) {
				int pathSum=0;
				for (Integer num : list) {
					pathSum+=num;
				}
				if(pathSum==sum){
					res.add(list);
				}
			}
			if (node.left != null) {
				nodes.push(node.left);
				List<Integer> leftList=new ArrayList<Integer>(list);
				leftList.add(node.left.val);
				paths.push(leftList);
			}
			if (node.right != null) {
				nodes.push(node.right);
				List<Integer> rightList=new ArrayList<Integer>(list);
				rightList.add(node.right.val);
				paths.push(rightList);
			}
		}
		return res;
	}
}
