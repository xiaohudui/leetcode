package easy;

import util.ListNode;

public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
    	if(node==null){
    		return;
    	}
    	ListNode pre=node;
    	ListNode cur=node.next;
    	while(pre!=null && cur!=null){
    		pre.val=cur.val;
    		if(cur.next==null){
    			pre.next=null;
    			break;
    		}
    		pre=pre.next;
    		cur=cur.next;
    	}
    }
    
    public void deleteNode1(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}
