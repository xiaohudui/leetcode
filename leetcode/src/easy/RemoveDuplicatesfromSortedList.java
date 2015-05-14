package easy;

import util.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode q = head;
		ListNode p = head.next;
		while (p != null) {
			if (p.val == q.val) {
				q.next = p.next;
			} else {
				q = p;
			}
			p = p.next;
		}
		return head;
	}
}
