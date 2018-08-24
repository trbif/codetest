/**
 * 
 */
package cn.code.lc;

import cn.code.tools.ListNode;

/**
 * @author zhangqi
 * @date 2018年3月15日 上午9:01:20
 * @version V1.0
 * @说明:
 */
public class SwapNodesinPairs24 {

    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null){
    		return head;
    	}
    	ListNode leader = new ListNode(-2);
    	ListNode helper = new ListNode(-1);
    	leader.next = helper;
    	helper.next = head;
    	ListNode nextHead = head;
    	ListNode left = null;
    	ListNode right = null;
    	while(nextHead!=null){
        	left = nextHead;
        	right = nextHead.next;
//    		System.out.println(left.val);
//    		System.out.println(right.val);
    		left.next = right.next;
    		right.next = left;
    		leader.next.next = right;
    		leader.next = left;
			nextHead = nextHead.next;
    	}
    	return head;
    }
    
    public ListNode swapPairsNew(ListNode head) {
        ListNode leader = new ListNode(0);
        leader.next = head;
        ListNode current = leader;
        while (current.next != null && current.next.next != null) {
            ListNode left = current.next;
            ListNode right = current.next.next;
            left.next = right.next;
            current.next = right;
            right.next = left;
            current = current.next.next;
        }
        return leader.next;
    }
    
    public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(5);
		ListNode test = new SwapNodesinPairs24().swapPairsNew(head);
		while(test!=null){
			System.out.println(test.val);
			test = test.next;
		}
	}
}
