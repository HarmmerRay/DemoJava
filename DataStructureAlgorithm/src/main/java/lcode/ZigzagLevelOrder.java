package lcode;

import structrue.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 锯齿状层次遍历，如第一层从左到右，第二层从右到左，第三层从左到右
 * 思路： 1.树的层次遍历，准备一个队列nodeQueue，用来层次遍历此队列
 * 2.每层设置一个参数isOrderLeft是否从左向右遍历节点，是的话则加入到nodeDeque的offerLast不是则offerHead
 * 3.每层后nodeDeque加入到result集合中,并设置isOrderLeft为相反的值。进入下一层，执行重复的逻辑。
 * @author: HammerRay
 * @date: 2024/4/20 上午9:53
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;
        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.addLast(curNode.val);
                } else {
                    levelList.addFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            result.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        System.out.println(deque);
    }
}
