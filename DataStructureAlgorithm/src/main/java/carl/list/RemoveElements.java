package carl.list;

import carl.ListNode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/5/8 下午7:04
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {return null;}

        ListNode result = head;
        // 将头结点值是val的全部去除
        while(head != null) {
            if(head.val == val){
                result = head.next;
                head = head.next;
            }else {
                result = head;
                break;
            }
        }
        // 从第一个头结点不是val的节点开始
        while (head != null && head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }

        return result;
    }
}
