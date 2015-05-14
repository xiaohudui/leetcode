package easy;
import java.util.ArrayList;
import java.util.List;

import util.ListNode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p=head;
		List<ListNode> list=new ArrayList<ListNode>();
		while(p!=null){
			list.add(p);
			p=p.next;
		}
		int pos=list.size()-n;
		if(pos==0){
			return head.next;
		}
		p=list.get(pos-1);
		p.next=p.next.next;
		return head;
	}
	public ListNode removeNthFromEnd1(ListNode head, int n){
		ListNode p=head,q=head;
		for (int i = 0; i < n; i++) {
			p=p.next;
		}
		if(p==null){
			return head.next;
		}
		while(p.next!=null){
			p=p.next;
			q=q.next;
		}
		q.next=q.next.next;
		return head;
	}
	public static void main(String[] args) {
		
	}
}