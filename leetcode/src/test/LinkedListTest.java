package test;

import medium.PartitionList;
import medium.RemoveDuplicatesfromSortedListII;
import util.ListNode;

@SuppressWarnings("all")
public class LinkedListTest {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(1);
		ListNode three = new ListNode(2);
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(2);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		ListNode res = new RemoveDuplicatesfromSortedListII().deleteDuplicates(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
