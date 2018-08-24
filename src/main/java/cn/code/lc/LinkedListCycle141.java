/**
 * 
 */
package cn.code.lc;

import cn.code.tools.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangqi
 * @date 2018��3��14�� ����2:42:13
 * @version V1.0
 * @˵��:
 */
public class LinkedListCycle141 {
	
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
