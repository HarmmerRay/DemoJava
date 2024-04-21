package structrue;



import javax.management.ListenerNotFoundException;
import java.util.List;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/21 下午10:27
 */
public class MyList {
    private final ListNode head = new ListNode();
    public MyList(int []nums){
        for (int i: nums) {
            head.val = i;
            head.next = new ListNode();
        }
    }
    public ListNode getHead(){
        return head;
    }
    public ListNode add(ListNode node){
        return node;
    }
    public ListNode delete(ListNode node){
        return node;
    }
    public ListNode update(ListNode node){
        return node;
    }
    public ListNode selectOne(ListNode node){
        return node;
    }

}
