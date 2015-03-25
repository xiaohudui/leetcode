package easy;
/**
 * tip:链表通过构造假头结点的方法往往可以避免讨论边界条件
 * @author xiaohu
 *
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode p=l1;
    	ListNode q=l2;
    	ListNode head=new ListNode(0);
    	ListNode r=head;
    	while(p!=null && q!=null){
    		if(p.val<=q.val){
    			r.next=p;
    			p=p.next;
    		}else{
    			r.next=q;
    			q=q.next;
    		}
    		r=r.next;
    	}
    	if(p==null){
    		r.next=q;
    	}else{
    		r.next=p;
    	}
    	return head.next;
    }
}
