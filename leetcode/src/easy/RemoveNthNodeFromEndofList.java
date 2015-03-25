package easy;
import java.util.ArrayList;
import java.util.List;
/**
 * 思路一：（空间换时间）用一个列表将所有的节点的引用保存下来，算出倒数第n个引用的位置
 * 思路二：两个指针，让一个指针先跑n，然后同时开始跑，最后先前的指针跑到头时随后的指针指向的就是要删除的位置
 * @author xiaohu
 *
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p=head;
		List<ListNode> list=new ArrayList<ListNode>();
		while(p!=null){
			list.add(p);
			p=p.next;
		}
		int pos=list.size()-n;
		if(pos==0){
			return head.next;
		}
		p=list.get(pos-1);
		p.next=p.next.next;
		return head;
	}
	public ListNode removeNthFromEnd1(ListNode head, int n){
		ListNode p=head,q=head;
		for (int i = 0; i < n; i++) {
			p=p.next;
		}
		if(p==null){
			return head.next;
		}
		while(p.next!=null){
			p=p.next;
			q=q.next;
		}
		q.next=q.next.next;
		return head;
	}
	public static void main(String[] args) {
		
	}
}