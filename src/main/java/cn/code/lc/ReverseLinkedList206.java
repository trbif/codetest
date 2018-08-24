/**
 * 
 */
package cn.code.lc;


import cn.code.tools.ListNode;

/**
 * @author zhangqi
 * @date 2018年3月16日 上午11:04:17
 * @version V1.0
 * @说明:
 */
public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
    	if(head==null||head.next==null){
    		return head;
    	}
    	ListNode helper = new ListNode(0);
    	helper.next = head;
    	ListNode right = head;
        return head;
    }
    
    public ListNode reverseListNew(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    
    public ListNode reverseListNewNew(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
        	ListNode next = head.next;
        	head.next = newHead;
        	newHead = head;
        	head = next;
        }
        return newHead;
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
		
		ListNode test = new ReverseLinkedList206().reverseListNew(list1);
		while(test!=null){
			System.out.println(test.val);
			test = test.next;
		}
	}
}
