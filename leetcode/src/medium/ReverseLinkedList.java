package medium;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
    	if(head==null ||head.next==null){
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
}
