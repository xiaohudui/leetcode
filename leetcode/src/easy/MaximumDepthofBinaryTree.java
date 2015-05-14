package easy;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int cnt1 = 1, cnt2 = 0, level = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			cnt1--;
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
				level++;
			}
		}
		return level;
	}
}
