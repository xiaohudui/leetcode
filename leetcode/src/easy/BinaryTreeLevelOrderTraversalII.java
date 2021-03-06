package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	Stack<List<Integer>> stack=new Stack<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		int cnt1 = 1, cnt2 = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			cnt1--;
			list.add(t.val);
			if (t.left != null) {
				queue.offer(t.left);
				cnt2++;
			}
			if (t.right != null) {
				queue.offer(t.right);
				cnt2++;
			}
			if (cnt1 == 0) {
				cnt1 = cnt2;
				cnt2 = 0;
				stack.push(list);
				list = new ArrayList<Integer>();
			}
		}
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
    }
}
