package medium;

import util.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p = newHead;
		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int temp = p.next.val;
				while (p.next!=null && p.next.val == temp) {
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}
		}
		return newHead.next;
	}
}
