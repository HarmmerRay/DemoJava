package carl.binarytree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description:  数组实现二叉树  父节点下标为i  左子节点2*i+1 右子节点2*i+2
 * @author: HammerRay
 * @date: 2024/5/9 下午10:10
 */
public class MyBinaryTree {
    private ArrayList<Integer> binaryTree;
    public MyBinaryTree() {
        binaryTree = new ArrayList<>();
    }
    public MyBinaryTree(ArrayList<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }
    public void printTree() {
        int num = 0;
        for(int i = 0,j=0; i < binaryTree.size();j++) {
            num = 2 ^ j + 1;
            for(int k = 0; k < num; k++) {
                System.out.print(binaryTree.get(i) + " ");
                i++;
            }
            System.out.println();
        }
    }
    public void exist(int value) {}
    public void insert(int value) {}
    public void delete(int value) {}

    public static void main(String[] args) {
        new ArrayList<>();
        new MyBinaryTree().printTree();
    }
}
