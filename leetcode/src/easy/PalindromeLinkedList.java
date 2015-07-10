package easy;

import util.ListNode;

public class PalindromeLinkedList {
	/**
	 * 快慢指针找到后半段，反转，判断是否和前半段相等
	 */
	public boolean isPalindrome(ListNode head) {
		if(head==null){
			return true;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode reversed = reverse(slow.next);
		slow.next=null;
		while (reversed != null) {
			if (head.val != reversed.val) {
				return false;
			}
			head = head.next;
			reversed = reversed.next;
		}
		return true;
	}
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode next = head.next.next;
		while (cur != null) {
			cur.next = pre;
			pre = cur;
			cur = next;
			if (next != null) {
				next = next.next;
			}
		}
		head.next = null;
		return pre;
	}
}
