package structrue;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/21 下午10:29
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
