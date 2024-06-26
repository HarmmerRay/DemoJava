package lcode;

/**
 * @description: K个一组翻转列表
 * @author: HammerRay
 * @date: 2024/3/31 下午7:55
 */

public class TwentyFive {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val,ListNode next) {this.val = val; this.next = next;}
    }
    class ListNode2 {
        int val;
        ListNode2 next;
        ListNode2 pre;
        ListNode2(){};
        ListNode2(int val) {this.val = val;}
        ListNode2(int val,ListNode2 next) {this.val = val;this.next = next;}
        ListNode2(int val,ListNode2 next,ListNode2 pre) {this.val = val;this.next = next;this.pre = pre;}
    }

    public ListNode reverseKGroup(ListNode head,int k){
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null){
            ListNode tail = pre;
            // tail指针探路，看看剩余的元素是否有k个
            for (int i = 0; i < k;++i){
                tail = tail.next;
                // 如果没有k个，则返回hair.next即链表头节点
                if(tail == null){
                    return hair.next;
                }
            }
            // 上面的循环结束后tail指向区间的最后一个元素
            ListNode nex = tail.next;
            // 倒转这个区间 head指向的区间的第一个元素
            ListNode[] reverse = reverseK(head,tail);
            // 函数返回回来的数组是 ListNode[]{tail,head} 已经调换的
            head = reverse[0];
            tail = reverse[1];
            // 把这个区间与前后区间连上
            // 与前
            pre.next = head;
            // 与后
            tail.next = nex;
            // pre置于下一区间的左外第一个元素处
            pre = tail;
            // head置于下一个区间的第一个元素处
            head = tail.next;
            //此时第一个区间的循环结束，并且把相应的指针，指向了从第二区间的角度来看与第一区间时候指针相对位置 相同的位置
        }
        return hair.next;
    }

    private ListNode[] reverseK(ListNode head,ListNode tail){
        // 思考算法 背景（条件）--》目的-->自己想怎么解决-->对照答案代码理解
        // 下面代码总体思想：把next指向的指针调转方向，向前指。tail成为head,head成为tail,
        // 区域之外的prev节点的下一个指向变化后的头结点，变化后尾节点的下一个指向区域之外的last节点.
        // 头前面的空节点的下一个，指向尾巴节点的下一个
        ListNode prev = tail.next;
        // 保存头节点
        ListNode p = head;
        while (prev != tail){
            // 保存头结点的下一个节点
            ListNode nex = p.next;
            // 头结点的下一个节点指向，本组下一组的首个元素，头结点成为尾节点
            p.next = prev;
            // prev更换到头结点的位置
            prev = p;
            // 之前的头结点，换到它的下一个节点的位置
            p = nex;
        }
        return new ListNode[]{tail,head};
    }
}
