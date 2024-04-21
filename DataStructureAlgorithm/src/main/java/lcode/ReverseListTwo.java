package lcode;

import structrue.ListNode;
import structrue.MyList;

/**
 * @description: 翻转链表2
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @author: HammerRay
 * @date: 2024/4/21 下午10:11
 */
public class ReverseListTwo {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = null;
        if(left > 1){
            result = head;
        }
        int i = 1;
        //保留left-1 left right right+1四个核心位置的node
        ListNode []nodes = new ListNode[4];
        while(head != null){
            if(i == left - 1){
                nodes[0] = head;
            }
            //顺次翻转[left,right]
            if (i == left){
                nodes[1] = head;
                while(i != right){
                    ListNode tmp = head.next;
                    tmp.next = head;
                    head = tmp;
                    i++;
                    head = head.next;
                }
                nodes[2] = head;
            }
            if(i == right + 1){
                nodes[3] = head;
                break;
            }
            head = head.next;
            i++;
        }
        nodes[0].next = nodes[2];
        nodes[1].next = nodes[3];
        return result;
    }
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6};
        ListNode node = new MyList(nums).getHead();
        node = ReverseListTwo.reverseBetween(node,2,4);
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
