package test;

import util.ListNode;
import easy.DeleteNodeinaLinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		new DeleteNodeinaLinkedList().deleteNode(two);
		ListNode res = head;
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
