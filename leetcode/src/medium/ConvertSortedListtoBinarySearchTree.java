package medium;

import java.util.ArrayList;
import java.util.List;

import util.ListNode;
import util.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return helper(list);
	}
	public TreeNode helper(List<Integer> list) {
		if (list.size() == 0) {
			return null;
		}
		TreeNode root = new TreeNode(list.get(list.size() / 2));
		root.left = helper(list.subList(0, list.size() / 2));
		root.right = helper(list.subList(list.size() / 2 + 1, list.size()));
		return root;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		System.out.println(new ConvertSortedListtoBinarySearchTree().sortedListToBST(head));
	}
}
