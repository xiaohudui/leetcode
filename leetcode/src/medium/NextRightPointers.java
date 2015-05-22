package medium;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeLinkNode;

public class NextRightPointers {
	/**
	 * level order,can't just use constant extra space
	 */
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		int curCnt = 1;
		int nextCnt = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeLinkNode node = queue.poll();
			curCnt--;
			if (node.left != null) {
				queue.offer(node.left);
				nextCnt++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nextCnt++;
			}
			if (curCnt == 0) {
				curCnt = nextCnt;
				nextCnt = 0;
			} else {
				node.next = queue.peek();
			}
		}
	}
	/**
	 * Think that it is perfect tree, use the next pointer instead of the queue
	 */
	public void connect1(TreeLinkNode root) {
		if(root==null){
			return;
		}
		TreeLinkNode preLevel = root;
		TreeLinkNode curLevel = null;
		TreeLinkNode lastRight=null;
		boolean isFirst = true;
		while (preLevel.left!=null) {
			while (preLevel != null) {
				if (isFirst) {
					curLevel = preLevel.left;
					isFirst=false;
				}else{
					lastRight.next=preLevel.left;
				}
				preLevel.left.next=preLevel.right;
				lastRight=preLevel.right;
				preLevel = preLevel.next;
			}
			preLevel = curLevel;
			isFirst=true;
		}
	}
}
