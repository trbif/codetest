/**
 * 
 */
package cn.code.lc;

import cn.code.tools.ListNode;

/**
 * @author zhangqi
 * @date 2018年3月14日 下午2:58:09
 * @version V1.0
 * @说明:
 */
public class ReorderList143 {
// Time Limit Exceeded
    public void reorderList(ListNode head) {
    	ListNode newHead = new ListNode(0);
    	newHead.next = head;
    	helper(newHead);
    }
    
    int deep = 0;
    
    private void helper(ListNode head){
//    	System.out.println("##########"+head.val);
    	if(head==null||head.next==null||head.next.next==null){
    		return;
    	}
    	System.out.println("deep: "+deep++);
    	System.out.println("val: "+head.next.val);
    	ListNode nodeTop = head.next;
    	ListNode nodeIndex = head.next;
    	ListNode nodeHelper = head;
    	int count = 0;
    	while(nodeIndex.next!=null){
    		nodeHelper = nodeHelper.next;
    		nodeIndex = nodeIndex.next;
//    		System.out.println(nodeHelper.val);
//    		System.out.println(nodeIndex.val);
    		count++;
    	}
    	if(count==1){
    		return;
    	}
    	System.out.println("nodeHelper: "+nodeHelper.val);
    	System.out.println("nodeIndex: "+nodeIndex.val);
    	System.out.println("nodeTop: "+nodeTop.val);
    	System.out.println("head: "+head.val);
    	nodeIndex.next = nodeTop.next;
    	head.next = nodeTop.next;
    	nodeTop.next = nodeIndex;
    	nodeHelper.next = null;
    	helper(head);
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2); 
    	head.next.next = new ListNode(3); 
    	head.next.next.next = new ListNode(4); 
    	head.next.next.next.next = new ListNode(5); 
		new ReorderList143().reorderList(head);
    	while(head!=null){
    		System.out.println(head.val);
			head = head.next;
		}
	}
    
}
