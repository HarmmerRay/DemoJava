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
    public static TreeNode initByBST(int []nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        return arrayToBST(nums,0,nums.length - 1);
    }
    private static TreeNode arrayToBST(int []nums,int start,int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = arrayToBST(nums,start,mid-1);
        node.right = arrayToBST(nums,mid+1,end);
        return node;
    }

    public static TreeNode initByLevelOrderArr(int []nums){
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
    public static void preOrderTraversal(TreeNode root){

        // 左右中
        if(root == null){
            return ;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val+" ");

    }
    public static void mediumOrderTraversal(TreeNode root){

        // 左中右
        if(root == null){
            return ;
        }
        mediumOrderTraversal(root.left);
        System.out.print(root.val+" ");
        mediumOrderTraversal(root.right);
    }
    public static void lastOrderTraversal(TreeNode root){

        // 中左右
        if(root == null){
            return ;
        }
        System.out.print(root.val+" ");
        lastOrderTraversal(root.left);
        lastOrderTraversal(root.right);
    }
    public static List<Integer> levelTraversalA(TreeNode root){
        // 创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                continue;
            }
            int value = node.val;
            System.out.print(value + " ");

            result.add(value);
            queue.add(node.left);
            queue.add(node.right);

        }
        return result;
    }
    public static List<List<Integer>> levelTraversalB(TreeNode root){
        List<List<Integer>> resultE = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        // 创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 来个计数器 （二叉树的第n层的个数是 1 2 4 8 2^(n-1) ，前n层的总节点数为2^n - 1）
        int nodeCounter = 0;
        int levelCounter = 0;
        while(!queue.isEmpty()){
            // Math函数中只有以e和10为底的求对数
            // 使用换底公式，制造求2的对数


            TreeNode node = queue.poll();
            if(node == null){
                nodeCounter++;
                continue;
            }
            int value = node.val;
            System.out.print(value + " ");

            result.add(value);
            queue.add(node.left);
            queue.add(node.right);
            nodeCounter++;
            if((Math.log(nodeCounter+1)/Math.log(2)) % 1 == 0 ){
                resultE.add(result);
                result = new LinkedList<>();
            }
        }

        return resultE;
    }
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        TreeNode root = initByBST(nums);
        // 1 3 2 5 7 6 4
        System.out.println("*********先序遍历*********");
        preOrderTraversal(root);
        System.out.println();

        // 1 2 3 4 5 6 7
        System.out.println("*********中序遍历*********");
        mediumOrderTraversal(root);
        System.out.println();

        // 4 2 1 3 6 5 7
        System.out.println("*********后序遍历*********");
        lastOrderTraversal(root);
        System.out.println();

        // 4 2 6 1 3 5 7
        System.out.println("*********层序遍历*********");
        System.out.println(levelTraversalA(root));
        System.out.println("*********层序遍历(打印层数)*********");
        System.out.println(levelTraversalB(root));

        int []numsB = {1,2,3,-1001,4,5,-1001};
        TreeNode rootB = initByLevelOrderArr(numsB);
        System.out.println(levelTraversalA(rootB));
    }
}
