package medium;
/**
 * 关于链表的问题，加上伪头指针会减少讨论
 * 
 * @author xiaohu
 *
 */
public class ReverseLinkedListII {
	/**
	 * 思路一：将m到n之间的所有指针反转，记住m和m之前的节点，然后接回去就行了
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int cnt = 1;
		ListNode pHead = new ListNode(0);
		pHead.next = head;
		ListNode p = pHead;
		if (m >= n || p.next.next == null) {
			return head;
		}
		while (cnt < m) {
			p = p.next;
			cnt++;
		}
		ListNode pm = p;
		ListNode pn = p.next;
		p = p.next;
		ListNode q = p.next;
		ListNode r = q.next;
		cnt++;
		while (cnt < n && r != null) {
			q.next = p;
			p = q;
			q = r;
			r = r.next;
			cnt++;
		}
		q.next = p;
		pm.next = q;
		pn.next = r;
		return pHead.next;
	}
	/**
	 * 思路二：找到第m个节点，将m节点后的节点插入m节点之前，m节点指向其后的节点
	 */
	public ListNode reverseBetween1(ListNode head, int m, int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode preNode=dummy;
		int i=1;
		while(preNode.next!=null && i<m){
			preNode=preNode.next;
			i++;
		}
		if(i<m){
			return head;
		}
		ListNode mNode=preNode.next;
		ListNode cur=mNode.next;
		while(cur!=null && i<n){
			ListNode next=cur.next;
			cur.next=preNode.next;
			preNode.next=cur;
			mNode.next=next;
			cur=next;
			i++;
		}
		return dummy.next;
	}
}
