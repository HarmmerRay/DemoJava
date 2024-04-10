package lcode;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @description: 二叉树的层次遍历
 * @author: HammerRay
 * @date: 2024/4/10 下午7:38
 */
public class LevelOrder {
    class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 根据队列先进先出，一层一层的入队出队
        List<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> levelRes = new LinkedList<>();
        // 入队
        add(queue,root);
        //加入标志位标志一层的结束
        add(queue,new TreeNode(1001,null,null));
        int level = 0;
        while(!queue.isEmpty()){

            if(judgeFlag(peekAndAdd(queue))){
                level ++;
                System.out.println("当前层数:"+level);
                res.add(levelRes);
                levelRes.clear();
            }else {
                levelRes.add(peekAndAdd(queue).val);
            }

        }

        return res;
    }

    public List<Integer> levelOrderOne(TreeNode root) {
        // 根据队列先进先出，一层一层的入队出队
        // 此处我偷了懒，一个一个地执行出队入队，返回的列表是整个树层次遍历的结果，不能分层。但是题目要求的是List<List<Integer>>，一层层的分开。
        List<TreeNode> queue = new LinkedList();
        List<Integer> res = new LinkedList();
        // 入队
        add(queue,root);
        while(queue.size()!=0){
            res.add(peekAndAdd(queue).val);
        }

        return res;
    }
    private boolean judgeFlag(TreeNode tmp){
        return tmp.val == 1001 && tmp.left == null && tmp.right == null;
    }
    private TreeNode peekAndAdd(List<TreeNode> linkedQueue){
        TreeNode res = peek(linkedQueue);

        if(res.left != null){
            add(linkedQueue,res);
        }
        if(res.right != null){
            add(linkedQueue,res);
        }
        return res;
    }
    private TreeNode peek(List<TreeNode> linkedQueue){
        return linkedQueue.remove(0);
    }
    private boolean add(List<TreeNode> linkedQueue,TreeNode node){
        linkedQueue.add(node);
        return true;
    }
    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.remove(0);

        for (Integer b:
             a) {
            System.out.println(b);
        }
        System.out.println(a);
    }
}
