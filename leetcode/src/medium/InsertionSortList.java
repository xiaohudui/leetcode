package medium;

import util.ListNode;
/**
 * 链表插入排序，插入点从开始找，找到插入点的前一个元素
 * 注意点一：如果进行了插入，r就不用后移，否则进行后移
 * 注意点二：无论是否进行插入，p都得复位，重新查找插入位置
 * @author xiaohu
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p = newHead;
		ListNode q;
		ListNode r = head;
		ListNode l;
		while (r.next != null) {
			while (p.next != null && p.next.val < r.next.val) {
				p = p.next;
			}
			if (p.next != r.next) {
				l = r.next;
				r.next = r.next.next;
				q = p.next;
				p.next = l;
				l.next = q;
			}else{
				r=r.next;
			}
			p = newHead;
		}
		return newHead.next;
	}
}
