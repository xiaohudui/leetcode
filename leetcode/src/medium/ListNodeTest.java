package medium;

public class ListNodeTest {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		ListNode head = new ReverseLinkedListII().reverseBetween(one, 3, 4);
		ListNode p = head;
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
}
