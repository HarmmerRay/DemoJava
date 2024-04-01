package dynamic.plan;

import java.util.Arrays;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/15 下午3:41
 */
public class Pack01 {
    public static void main(String[] args) {
        int V = 10;
        int N = 6;
        int[] weight = new int[]{0,1,5,2,3,6,1};
        int[] value = new int[]{0,15,59,21,30,60,5};

        System.out.println("背包载重量：" + V);
        System.out.println("物品数量：" + N);
        System.out.println("物品重量：" + Arrays.toString(weight));
        System.out.println("相对应的物品价值：" + Arrays.toString(value));

        getResults(V, N, weight, value);
    }

    /**
     * 求得动态规划表
     */
    private static int[][] pack01 (int V, int N, int[] weight, int[] value) {
        int[][] dp = new int[N + 1][V + 1];
        //当什么物品都不选择的时候，无论容量是什么价值都为零
        for (int col =0; col <= V ; col++){
            dp[0][col] = 0;
        }
        //当容量为零时，无论选择哪个物品总价值都为零
        for (int row = 0;row <= N; row++){
            dp[row][0] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {

                //如果第i件物品的重量大于背包容量j,则第i件物品不装入背包，存放前i-1个物品的价值
                if (weight[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    //解锁第i个物品后，比较存放前i-1个物品的价值与当前物品的价值+可以容纳的剩余重量的价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp;
    }

    /**
     * 已知动态规划表，求背包内的最优解 最优值 打印动态规划表
     */
    private static void getResults(int V, int N, int[] weight, int[] value) {
        int[][] dp = pack01(V, N, weight, value);

        System.out.println("动态规划表如下：");
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("最优值：" + dp[N][V]);

        boolean[] flags = new boolean[N + 1];

        for (int i = N; i > 0; i--) {
            //如果dp[i][j] == dp[i-1][j]，则说明第i个物品没有放入dp[i][j]中，否则反之
            if (dp[i][V] > dp[i - 1][V]) {
                flags[i] = true;
                //放入物品后背包容量减少
                V -= weight[i];
            }

        }

        System.out.print("最优解：(");
        for (int i = 1; i <= N; i++) {
            if (flags[i]) {
                if( i == N){
                    System.out.print(1);
                }else{
                    System.out.print(1 + ",");
                }

            }else {
                if( i == N){
                    System.out.print(0);
                }else {
                    System.out.print(0 + ",");
                }

            }
        }
        System.out.print(")");
    }

}
