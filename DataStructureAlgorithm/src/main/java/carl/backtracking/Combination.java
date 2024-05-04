package carl.backtracking;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:  回溯法
 * Leetcode 77. 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * @author: HammerRay
 * @date: 2024/5/4 下午4:59
 */
public class Combination {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return resList;
    }

    private void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            resList.add(new ArrayList<>(path));
            return;

        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
