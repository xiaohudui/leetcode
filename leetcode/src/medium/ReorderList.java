package medium;

import util.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
    	if(head==null ||head.next==null){
    		return;
    	}
    	ListNode fast=head;
    	ListNode slow=head;
    	while(fast.next!=null && fast.next.next!=null){
    		slow=slow.next;
    		fast=fast.next;
    	}
    	ListNode head1=head;
    	ListNode head2=reverse1(slow.next);
    	slow.next=null;
    	while(head1!=null && head2!=null){
    		ListNode temp=head2.next;
    		head2.next=head1.next;
    		head1.next=head2;
    		head1=head2.next;
    		head2=temp;
    	}
    }
    public ListNode reverse(ListNode head){
    	if(head==null || head.next==null){
    		return head;
    	}
    	ListNode p=head;
    	ListNode q=head.next;
    	ListNode r=head.next.next;
    	while(r!=null){
    		q.next=p;
    		p=q;
    		q=r;
    		r=r.next;
    	}
    	q.next=p;
    	head.next=null;
    	return q;
    }
    /**
     * 没有多余的判断的简洁的方法
     * @param head
     * @return
     */
    public ListNode reverse1(ListNode head){
    	ListNode pre=null;
    	ListNode cur=head;
    	while(cur!=null){
    		ListNode next=cur.next;
    		cur.next=pre;
    		pre=cur;
    		cur=next;
    	}
    	return pre;
    }
}
