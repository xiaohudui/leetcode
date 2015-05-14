package medium;

import util.ListNode;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		int cnt = 1;
		ListNode pHead = new ListNode(0);
		pHead.next = head;
		ListNode p = pHead;
		if (m >= n || p.next.next == null) {
			return head;
		}
		while (cnt < m) {
			p = p.next;
			cnt++;
		}
		ListNode pm = p;
		ListNode pn = p.next;
		p = p.next;
		ListNode q = p.next;
		ListNode r = q.next;
		cnt++;
		while (cnt < n && r != null) {
			q.next = p;
			p = q;
			q = r;
			r = r.next;
			cnt++;
		}
		q.next = p;
		pm.next = q;
		pn.next = r;
		return pHead.next;
	}
	/**
	 * ˼·�����ҵ���m���ڵ㣬��m�ڵ��Ľڵ����m�ڵ�֮ǰ��m�ڵ�ָ�����Ľڵ�
	 */
	public ListNode reverseBetween1(ListNode head, int m, int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode preNode=dummy;
		int i=1;
		while(preNode.next!=null && i<m){
			preNode=preNode.next;
			i++;
		}
		if(i<m){
			return head;
		}
		ListNode mNode=preNode.next;
		ListNode cur=mNode.next;
		while(cur!=null && i<n){
			ListNode next=cur.next;
			cur.next=preNode.next;
			preNode.next=cur;
			mNode.next=next;
			cur=next;
			i++;
		}
		return dummy.next;
	}
}
