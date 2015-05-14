package medium;

import util.ListNode;
/**
 * 陷阱一：head自环
 * 陷阱二：只有一个节点，没有移动也会造成 fast=slow
 * 原则：先正确，后简洁
 * @author xiaohu
 *
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        	if(fast==slow){
        		break;
        	}
        }
        if(fast!=slow){
        	return null;
        }
        slow=head;
        while(fast!=slow){
        	fast=fast.next;
        	slow=slow.next;
        }
        return fast;
    }
}
