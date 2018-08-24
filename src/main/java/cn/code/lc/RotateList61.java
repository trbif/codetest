package cn.code.lc;

import cn.code.tools.ListNode;

public class RotateList61 {

    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null||head.next==null){
    		return head;
    	}
    	ListNode helperLeft = head;
    	ListNode helper = helperLeft;
    	ListNode helperRight = head.next;
    	while(helperRight.next!=null){
    		helperRight = helperRight.next;
    	}
    	while(k>0){
    		helperLeft = helperLeft.next;
        	if(helperLeft==null){
        		return head;
        	}
    		k--;
    	}
    	if(helperLeft.next!=null){
    		helper = helperLeft.next;
			helperLeft.next = null;
			helperLeft = helper;
    		helperRight.next = head;
    	}else{
    		return head;
    	}
        return helperLeft;
    }
    
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode helper = head;
		for(int i=2;i<=2;i++){
			helper.next = new ListNode(i);
			helper = helper.next;
		}
		ListNode result = new RotateList61().rotateRight(head, 2);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
