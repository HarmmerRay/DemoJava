package lcode;

import structrue.BinaryTree;
import structrue.TreeNode;
import java.util.LinkedList;

/**
 * @description: 最近公共父节点
 * @author: HammerRay
 * @date: 2024/4/17 下午8:46
 */
public class LowestCommonAncestor {
    private LinkedList<TreeNode> arr = new LinkedList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 先序遍历找到两个节点，并且记录它们的路径。

        // 从前向后，找到最后一对相同的节点，及它们的最近公共祖先
        TreeNode[] pArr = find(root,p);
        TreeNode[] qArr = find(root,q);
        return latestAncestor(pArr,qArr);

    }
    private TreeNode[] find(TreeNode root,TreeNode target){
        preFind(root,target);
        TreeNode[] result = new TreeNode[10];

        for (TreeNode item: arr.toArray(result)) {
            System.out.print(item.val + " ");
        }
        arr.clear();
        return result;
    }
    private void preFind(TreeNode root,TreeNode target){
        if(root == null ){
            return;
        }
        if(root.val == target.val){
            arr.add(root);
            return;
        }
        preFind(root.left,target);
        preFind(root.right,target);
        arr.add(root);
    }
    private TreeNode latestAncestor(TreeNode[] arr1,TreeNode[] arr2){
        int length = Math.min(arr1.length, arr2.length);
        for (int i = 0; i < length; i++) {
            if(arr1[i] != arr2[i]){
                return arr1[i-1];
            }
        }
        return arr1[0];
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(5);
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(BinaryTree.initByLevelOrderArr(new int[]{1,2,3,4,5,6,7}),p,q).val);

    }
}
