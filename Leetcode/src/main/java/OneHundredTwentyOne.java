import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/11 上午6:29
 */
public class OneHundredTwentyOne {
    public static int maxLoss(int[] prices) {
        // 最快赔钱法(适用于西虹市首富)
        int[] profits = new int[prices.length - 1];
        // 取当前下标的值a
        for (int i = 0; i < prices.length - 1; i++) {
            int min = prices[i + 1];
            // 找到a后面所有的值中最小的值b
            for (int j = i + 2; j < prices.length; j++) {
                if (prices[j] < min) {
                    min = prices[j];
                }
            }
            // a-b的值放入一个新的数组arr2中
            profits[i] = prices[i] - min;
        }
        // 对arr2进行冒泡查找，找到最大的值
        sort(profits);
        for (int profit : profits) {
            System.out.println(profit);
        }
        return profits[profits.length - 1];
    }

    public static int maxProfit(int[] prices) {
        // 最快挣钱方法（超出最大时间复杂度）暴力破解 时间复杂度O(n^2)
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > 0){
                    if(prices[j] - prices[i] > maxProfit){
                       maxProfit = prices[j] - prices[i];
                    }
                }
            }
        }

        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        // 价格最低的点位
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;

    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};

//        maxLoss(nums);
        System.out.println(maxProfit(nums));
    }
}
