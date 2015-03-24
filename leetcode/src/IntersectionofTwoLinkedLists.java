public class IntersectionofTwoLinkedLists {
	/**
	 * 思路：A和B同时从开始跑，A跑完接着从B开始跑，B跑完接着从A开始，他们会相遇在公共节点
	 * 此时，A跑了三个半截，B也跑了三个半截链
	 * 如果刚好没有交点，两者在都为null相等
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode1(ListNode headA,ListNode headB){
		ListNode p=headA;
		ListNode q=headB;
		while(p!=q){
			if(p==null){
				p=headB;
			}else{
				p=p.next;
			}
			if(q==null){
				q=headA;
			}else{
				q=q.next;
			}
		}
		return p;
	}
	/**
	 * 思路：计数A，B的长度，长的先走过长出的部分
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p=headA;
		ListNode q=headB;
		int countA=getCount(headA);
		int countB=getCount(headB);
		if(countA>countB){
			while(countA>countB){
				p=p.next;
				countA--;
			}
		}else{
			while(countB-countA>0){
				q=q.next;
				countB--;
			}
		}
		while(p!=null && p!=q){
			p=p.next;
			q=q.next;
		}
		return p;
	}
	public int getCount(ListNode head){
		int cnt=0;
		ListNode p=head;
		while(p!=null){
			p=p.next;
			cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		ListNode q=null;
		ListNode p=null;
		System.out.println(p==q);
	}
}
