/**
 * 
 */
package cn.code.lc;

import cn.code.tools.ListNode;

/**
 * @author zhangqi
 * @date 2018年3月22日 下午1:34:59
 * @version V1.0
 * @说明:
 */
public class RemoveLinkedListElements203 {

    public ListNode removeElements(ListNode head, int val) {
    	if(head==null){
    		return head;
    	}
    	ListNode newHead = new ListNode(0);
    	newHead.next = head;
    	ListNode pre = newHead; 
    	ListNode pivot = newHead.next; 
    	while(pivot!=null){
    		if(pivot.val==val){
    			pre.next = pivot.next;
    		}else{
    			pre = pre.next;
    		}
			pivot = pivot.next;
    	}
        return newHead.next;
    }
    
    public static void main(String[] args) {
		
	}
}
