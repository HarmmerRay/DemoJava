package lcode;

/**
 * @description: 300.最长递增子序列
 * @author: HammerRay
 * @date: 2024/4/26 下午2:22
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        // 子序列 严格递增  最长
        // dp[i] 为包括nums[i]的前i+1个元素的，最长子序列
        int maxLength = 1;
        int []dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length ; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    // 重点：一次检查i之前所有的元素dp[i]，大于它就在dp[i]和dp[j] + 1选出最大的
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int []nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
}
