package lcode;

/**
 * @description: 不知道和最大的连续子数组一定会选哪一个数（有后效性） --> −3 是连续子数组的第几个元素，定义为最后一个元素(无后效性)
 * @author: HammerRay
 * @date: 2024/4/4 下午11:23
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        // 动态规划问题：定义子问题(定义状态) -> 状态转移方程（子问题如何变化） -> 找到最优子问题
        // 有后效性 无后效性：下一个子问题的解不会因为上一个子问题的解难以求得或者不确定，上一个子问题的解求得之后不会改变。

        int len = nums.length;
        // dp[i]表示 ：以nums[i]结尾的连续子数组的最大和
        int []dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        // 代码空间可以使用for(int num: nums) 和 Math.max()进一步优化
        for(int i = 1;i < len; i++){
            if (dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            res = Math.max(res,dp[i]);
        }
        return res;
        // 也可以在上面遍历的同时求出res的最大值
    }
    public int maxSubArray1(int[] nums) {
        // 线段树 即 分治思想的二叉树结构 [a,b]的左节点[a,(a+b)/2],右节点[(a+b)/2,b]
        return 0;
    }

}
