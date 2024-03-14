/**
 * @projectName: DemoJava
 * @package: PACKAGE_NAME
 * @className: OneHundredTwentyTwo
 * @author: HammerRay
 * @description: TODO
 * @date: 3/12/2024 11:39 PM
 * @version: 1.0
 */

public class OneHundredTwentyTwo {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

}
