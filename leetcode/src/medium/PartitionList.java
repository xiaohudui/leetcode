package medium;

import util.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode insertPoint=null;
		ListNode newHead=new ListNode(0);
		newHead.next=head;
		ListNode p=newHead;
		ListNode q=newHead.next;
		while(q!=null){
			if(insertPoint==null && q.val>=x){
				insertPoint=p;
			}
			if(insertPoint!=null && q.val<x){
				p.next=q.next;
				q.next=insertPoint.next;
				insertPoint.next=q;
				insertPoint=insertPoint.next;
			}else{
				p=p.next;
			}
			q=p.next;
		}
		return newHead.next;
	}
}
