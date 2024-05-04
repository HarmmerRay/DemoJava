package lcode;

import java.util.Stack;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/5/3 下午11:17
 */
public class PickUpRain {
    public int trap(int[] height) {
        // 动态规划
        int n = height.length;
        if (n == 0){
            return 0;
        }
        // 思路：pickUp[i] 等于 左右两边的最长柱子高度的其中短柱子高度减去height[i]，因为每次这样去计算需要对每一个i,进行时间复杂度为n的计算pickUp[i]操作,总体时间复杂度为n^2
        // 用DP优化，动态规划即上一层计算的结果可以为第二层所用
        // leftMax[i] = Max(leftMax[i-1],height[i])
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1;i < n; ++i){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2;i >= 0; --i){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int result = 0;
        for(int i = 0; i < n; ++i){
            result += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return result;
    }
    public int trapB(int[] height){
        int result = 0;
        int n = height.length;
        if (n == 0){
            return 0;
        }

        return result;
    }
}
