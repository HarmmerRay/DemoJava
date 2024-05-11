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
    private int powersOfTwo(int x) {
        int result = 1;
        for (int i = 0; i < x; i++) {
            result *= 2;
        }
        return result;
    }
    public void printTree() {
        int num = 0;
        for(int i = 0,j=0; i < binaryTree.size();j++) {
            num = powersOfTwo(j);
            for(int k = 0; k < num; k++) {
                if(i < binaryTree.size()) {
                    System.out.print(binaryTree.get(i) + " ");
                    i++;
                }else {
                    break;
                }
            }
            System.out.println();
        }
    }
    public void exist(int value) {}
    public void insert(int value) {}
    public void delete(int value) {}

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        new MyBinaryTree(list).printTree();
    }
}
