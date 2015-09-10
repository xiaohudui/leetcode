package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ListNode;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
    	Map<Integer,ListNode> map=new HashMap<Integer,ListNode>();
    	List<ListNode> removed=new ArrayList<ListNode>();
    	ListNode newHead=new ListNode(0);
    	newHead.next=head;
    	ListNode p=newHead;
    	ListNode q=newHead.next;
    	while(q!=null){
    		if(map.containsKey(q.val)){
    			p.next=q.next;
    			removed.add(map.get(q.val));
    		}else{
    			map.put(q.val, p);
    			p=p.next;
    		}
    		q=p.next;
    	}
    	for(int i=removed.size()-1;i>=0;i--){
    		ListNode node=removed.get(i);
    		node.next=node.next.next;
    	}
    	return newHead.next;
    }
}
