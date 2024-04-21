package lcode;

import structrue.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/15 下午10:36
 */
public class HasCircle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
