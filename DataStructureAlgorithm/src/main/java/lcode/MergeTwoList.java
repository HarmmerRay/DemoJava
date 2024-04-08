package lcode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/7 下午4:13
 */
public class MergeTwoList {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(ListNode next) {
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        // 判断当前头结点的值那个小，然后将小的那个头结点的next指向 其余节点合并的结果!
        if(l1 == null){
            return l2;
        }else if(l2 == null){
                return l1;
            }else if(l1.val < l2.val){
                    l1.next = mergeTwoLists(l1.next,l2);
                    return l1;
                }else {
                    l2.next = mergeTwoLists(l1,l2.next);
                    return l2;
                }
    }
}
