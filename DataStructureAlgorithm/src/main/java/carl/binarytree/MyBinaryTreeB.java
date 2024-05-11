package carl.binarytree;

/**
 * @description:  、
 * 递归三要素：1.确定参数和返回值，什么参数递归过程中需要处理，什么返回值需要层层返回
 * 2.确定终止条件
 * 3.确定单层重复调用自己的逻辑
 * @author: HammerRay
 * @date: 2024/5/10 上午9:17
 */
public class MyBinaryTreeB {
    private TreeNode root;
    public MyBinaryTreeB() {
        this.root = null;
    }
    public MyBinaryTreeB(TreeNode root){
        this.root = root;
    }
    /**
     * description: 前序遍历 中左右  中序遍历 左中右  后序遍历 左右中
     * @paramType [carl.binarytree.TreeNode]
     * @param root:
     * @returnType: void
     * @author: GodHammer
     * @date: 2024-05-10 上午9:38
     */
    public void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

    }
    public void midOrder(TreeNode root){
        System.out.println();
    }
    public void posOrder(TreeNode root){}
    public void levelOrder(TreeNode root){}
}
