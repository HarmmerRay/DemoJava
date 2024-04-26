package lcode;

import structrue.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/26 上午1:07
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){

        Set<ListNode> set = new HashSet<ListNode>();
        while(headA != null || headB != null){
            if(headA != null){
                if(set.contains(headA)){
                    return headA;
                }else {
                    set.add(headA);
                }
                headA = headA.next;

            }
            if(headB != null){
                if(set.contains(headB)){
                    return headB;
                }else {
                    set.add(headB);
                }
                headB = headB.next;
            }
        }
        return null;

    }
    /**
     * description: 上一个方法还用了hashmap的不重复特性，开辟了新的空间 低效   其实不用，以节点不同为条件两个链表交织检查就好
     * @paramType [structrue.ListNode, structrue.ListNode]
     * @param headA:
     * @param headB:
     * @returnType: structrue.ListNode
     * @author: GodHammer
     * @date: 2024-04-26 下午1:39
     */
    public ListNode getIntersectionNodeA(ListNode headA,ListNode headB){

        if(headA == null && headB == null){
            return null;
        }

        while(headA != headB){
            headA = headA == null ? headB : headA.next ;
            headB = headB == null ? headA : headB.next ;
        }
        return headA;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(new ListNode()));

    }
}
