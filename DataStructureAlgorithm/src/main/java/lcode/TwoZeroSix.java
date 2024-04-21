package lcode;

import structrue.ListNode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/21 下午11:16
 */
public class TwoZeroSix {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;


    }
}



