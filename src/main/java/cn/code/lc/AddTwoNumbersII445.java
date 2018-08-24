/**
 * 
 */
package cn.code.lc;

import cn.code.tools.ListNode;

import java.util.Stack;

/**
 * @author zhangqi
 * @date 2018年3月22日 下午4:20:31
 * @version V1.0
 * @说明:
 */
public class AddTwoNumbersII445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }        
        int sum = 0;
        ListNode result = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            result.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = result;
            result = head;
            sum /= 10;
        }
    	return (result.val==0)?((result.next==null)?(result):(result.next)):result;
    }
}
