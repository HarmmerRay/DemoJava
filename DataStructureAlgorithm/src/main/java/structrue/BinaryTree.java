package structrue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/10 下午8:54
 */
public class BinaryTree {
    public TreeNode initToBST(int []nums){
        TreeNode root = new TreeNode(nums[nums.length/2]);
        return root;
    }
    public TreeNode initByLevelOrderArr(int []nums){
        // -1001为空节点
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode currentNode = queue.poll();
            // 检查是否为空节点
            if (nums[i] != -1001) {
                currentNode.left = new TreeNode(nums[i++]);
                queue.offer(currentNode.left);
            }
            if (i < nums.length && nums[i] != -1001) {
                currentNode.right = new TreeNode(nums[i++]);
                queue.offer(currentNode.right);
            }
        }
        return root;
    }
    public static List<TreeNode> preOrderTraversal(TreeNode root){

    }
    public static List<TreeNode> mediumOrderTraversal(TreeNode root){

    }
    public static List<TreeNode> lastOrderTraversal(TreeNode root){

    }
    public static List<TreeNode> levelTraversalA(TreeNode root){

    }
    public static List<List<TreeNode>> levelTraversalB(TreeNode root){

    }
    public static void main(String[] args) {

    }
}
