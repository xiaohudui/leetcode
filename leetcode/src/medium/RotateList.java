package medium;

import util.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null){
    		return null;
    	}
        int len=0;
        ListNode node=head;
        while(node.next!=null){
        	len++;
        	node=node.next;
        }
        ListNode tail=node;
        k=k%(len+1);
        if(k==0){
        	return head;
        }
        int cnt=len-k;
        node=head;
        while(cnt-->0){
        	node=node.next;
        }
        ListNode newHead=node.next;
        node.next=null;
        tail.next=head;
        return newHead;
    }
}
