/**
 * 
 */
package cn.code.lc;

import cn.code.tools.ListNode;

/**
 * @author zhangqi
 * @date 2018年3月16日 下午1:45:42
 * @version V1.0
 * @说明:
 */
public class ReverseLinkedListII92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head==null||head.next==null||m==n){
    		return head;
    	}
    	ListNode newHead = new ListNode(0);
    	newHead.next = head;
    	ListNode leftHead = newHead;
    	ListNode leftCurrent = newHead.next;
    	int leftCount = 1;
    	while(leftCurrent!=null){
    		if(leftCount++==m){
    			break;
    		}
    		leftHead = leftHead.next;
    		leftCurrent = leftCurrent.next;
    	}
    	ListNode rightHead = newHead;
    	ListNode rightCurrent = newHead.next;
    	int rightCount = 1;
    	while(rightCurrent!=null){
    		if(rightCount++==n){
    			break;
    		}
    		rightHead = rightHead.next;
    		rightCurrent = rightCurrent.next;
    	}
    	if(leftCurrent==null||rightCurrent==null){
    		return head;
    	}
//    	System.out.println(leftCurrent.val);
//    	System.out.println(rightCurrent.val);
    	ListNode tail = rightCurrent.next;
    	leftHead.next = rightCurrent;
    	rightCurrent.next = leftCurrent.next;
    	rightHead.next = leftCurrent;
    	leftCurrent.next = tail;
        return head;
    }

    public static void main(String[] args) {
		ListNode list1 = new ListNode(0);
		ListNode head1 = list1;
		int i=1;
		while(i<10){
			head1.next = new ListNode(i);
			head1 = head1.next;
			i++;
		}
		
		ListNode test = new ReverseLinkedListII92().reverseBetween(list1,2,4);
		while(test!=null){
			System.out.println(test.val);
			test = test.next;
		}
	}
}
