package medium;

import util.ListNode;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next=head;
		ListNode prev = newHead;
		ListNode cur = head;
		ListNode post=head.next;

		while (post != null) {
			ListNode temp=post.next;
			prev.next=post;
			post.next=cur;
			cur.next=temp;
			if(temp==null){
				break;
			}
			prev=cur;
			cur=temp;
			post=temp.next;
		}
		return newHead.next;
	}
}
