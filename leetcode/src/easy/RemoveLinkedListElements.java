package easy;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead=new ListNode(0);
        newHead.next=head;
        ListNode p=newHead;
        ListNode q=head;
        while(q!=null){
        	if(q.val==val){
        		p.next=q.next;
        		q=p.next;
        	}else{
        		p=p.next;
        		q=q.next;
        	}
        }
        return newHead.next;
    }
}
