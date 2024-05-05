package carl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: DemoJava
 * @package: carl.backtracking
 * @className: CombinationSum3
 * @author: HammerRay
 * @description: 思路十分清楚 代码清晰易懂
 * 回溯法架构： if(返回条件);
 *              for(item: 横向所有元素){
 *                  处理元素；
 *                  backtrack(开始位置，路径）;
 *                  remove回溯一个元素;
 *              }
 * @date: 5/5/2024 10:00 PM
 * @version: 1.0
 */

public class CombinationSumC {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> item = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1,k,n);

        return res;
    }
    private void backtrack(int begin,int k, int n){
        if(k <= 0 ){
            if(n == 0){
                res.add(new ArrayList<>(item));
            }
            return;
        }
        for(int i = begin; i <= 9; i++){
            item.add(i);
            backtrack(i+1,k-1,n-i);
            item.remove(item.size()-1);
        }
    }
}
