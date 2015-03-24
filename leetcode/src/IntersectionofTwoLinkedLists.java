public class IntersectionofTwoLinkedLists {
	/**
	 * ˼·��A��Bͬʱ�ӿ�ʼ�ܣ�A������Ŵ�B��ʼ�ܣ�B������Ŵ�A��ʼ�����ǻ������ڹ����ڵ�
	 * ��ʱ��A����������أ�BҲ�������������
	 * ����պ�û�н��㣬�����ڶ�Ϊnull���
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
	 * ˼·������A��B�ĳ��ȣ��������߹������Ĳ���
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
