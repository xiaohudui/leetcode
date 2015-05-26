package medium;

import util.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
        	return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }
        fast=slow.next;
        slow.next=null;
        slow=fast;
        fast=sortList(head);
        slow=sortList(slow);
        return merge(fast,slow);
    }
    public ListNode merge(ListNode head1,ListNode head2){
    	if(head1==null){
    		return head2;
    	}
    	if(head2==null){
    		return head1;
    	}
    	ListNode res,p;
    	if(head1.val<head2.val){
    		res=head1;
    		head1=head1.next;
    	}else{
    		res=head2;
    		head2=head2.next;
    	}
    	p=res;
    	while(head1!=null && head2!=null){
    		if(head1.val<head2.val){
    			p.next=head1;
    			head1=head1.next;
    			p=p.next;
    		}else{
    			p.next=head2;
    			head2=head2.next;
    			p=p.next;
    		}
    	}
    	if(head1==null){
    		p.next=head2;
    	}else{
    		p.next=head1;
    	}
    	return res;
    }
}
