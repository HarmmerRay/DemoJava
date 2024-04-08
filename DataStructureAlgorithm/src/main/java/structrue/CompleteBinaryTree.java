package structrue;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/7 下午10:02
 */
public class CompleteBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){};
        public TreeNode(int val,TreeNode left,TreeNode right){this.val = val;this.left = left;this.right = right;};
    }
    public CompleteBinaryTree(){
        //构造完全二叉树
        // 树的节点个数n与树高h的关系，n=2^h-1
        int []nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    }
    private void construct(TreeNode node){

        construct(node.left);
        construct(node.right);
    }
}
