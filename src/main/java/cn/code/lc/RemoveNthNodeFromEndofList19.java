/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月12日 下午1:54:27
 * @version V1.0
 * @说明:
 */
public class RemoveNthNodeFromEndofList19 {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

//	 Given linked list: 0->1->2, and n = 2.
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode newHead = new ListNode(0);
    	newHead.next = head;
    	ListNode p = newHead;
    	ListNode q = newHead;
    	for(int i=0;i<=n;i++){
    		q = q.next;
    	}
    	while(q!=null){
    		p = p.next;
    		q = q.next;
    	}
    	p.next = p.next.next;
    	return newHead.next;
    }
}
