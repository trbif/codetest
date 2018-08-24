/**
 * 
 */
package cn.code.lc;

import cn.code.tools.ListNode;

/**
 * @author zhangqi
 * @date 2018年3月15日 下午1:25:00
 * @version V1.0
 * @说明:
 */
public class MergekSortedLists23 {

	// Time Limit Exceeded 
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length==0){
    		return null;
    	}
    	ListNode list = new ListNode(0);
    	ListNode head = list;
    	while(true){
    		int minIndex = -1;
    		int min = Integer.MAX_VALUE;
    		int count = 0;
        	for(int i=0;i<lists.length;i++){
        		System.out.println("##########");
        		if(lists[i]==null){
        			count++;
        			continue;
        		}
        		if(min>lists[i].val){
        			min = lists[i].val;
        			minIndex = i;
        		}
        	}
        	System.out.println(min);
        	if(count==lists.length)
        		break;
        	head.next = new ListNode(min);
    		lists[minIndex] = lists[minIndex].next;
        	head = head.next;
    	}
    	return list.next;
    }
    
    public static void main(String[] args) {
		ListNode list1 = new ListNode(0);
		ListNode head1 = list1;
		int i=1;
		while(i<10){
			head1.next = new ListNode(i*2);
			head1 = head1.next;
			i++;
		}
		ListNode list2 = new ListNode(0);
		ListNode head2 = list2;
		i=-1;
		while(i<10){
			head2.next = new ListNode(i*2);
			head2 = head2.next;
			i++;
		}
//		list1 = list1.next;
//		while(list1!=null){
//			System.out.println(list1.val);
//			list1 = list1.next;
//		}
		
		ListNode test = new MergekSortedLists23().mergeKLists(new ListNode[] {list1.next,list2.next});
		while(test!=null){
			System.out.println(test.val);
			test = test.next;
		}
	}
}
