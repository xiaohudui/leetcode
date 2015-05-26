package test;

import medium.SortList;
import util.ListNode;

public class LinkedListTest {
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode one = new ListNode(4);
		ListNode two = new ListNode(1);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(2);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		ListNode res = new SortList().sortList(head);
		while (res != null) {
			System.out.println(res.val);
			res=res.next;
		}
	}
}
