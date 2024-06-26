package lcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/19 下午5:19
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backTrack(n,output,res,0);
        return res;
    }
    public void backTrack(int n,List<Integer> output,List<List<Integer>> res,int first){
        // 所有的数都填完了
        if (first == n){
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n;i++){
            // 动态维护数组
            Collections.swap(output,first,i);
            // 继续递归填下一个数
            backTrack(n,output,res,first+1);
            // 撤销操作
            Collections.swap(output,first,i);
        }
    }
}
