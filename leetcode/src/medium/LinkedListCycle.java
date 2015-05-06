package medium;

import java.util.HashSet;

public class LinkedListCycle {
	/**
	 * 思路一：set存储所有节点，遇到重复就表明有环
	 * 时间复杂度：N
	 * 空间复杂度：N
	 */
    public boolean hasCycle(ListNode head) {
    	HashSet<ListNode> set=new HashSet<ListNode>();
    	ListNode p=head;
    	while(p!=null){
    		if(set.contains(p)){
    			return true;
    		}else{
    			set.add(p);
    		}
    		p=p.next;
    	}
        return false;
    }
    /**
     * 思路二：快慢环
     */
    public boolean hasCycle1(ListNode head){
    	ListNode slow=head;
    	ListNode fast=head;
    	while(fast!=null && fast.next!=null){
    		slow=slow.next;
    		fast=fast.next.next;
    		if(fast==slow){
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * 思路三：指针反转
     */
    public boolean hasCycle2(ListNode head){
    	if(head==null || head.next==null){
    		return false;
    	}
    	ListNode p=head;
    	ListNode q=head.next;
    	ListNode r=head.next.next;
    	while(r!=null){
    		q.next=p;
    		p=q;
    		q=r;
    		r=r.next;
    		if(r==head){
    			return true;
    		}
    	}
    	return false;
    }
}
