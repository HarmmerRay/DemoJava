package carl.dp;

/**
 * @description: 动态规划解题步骤：1.确定dp数组及下标的含义 2.确定递推公式 3.如何初始化dp数组 4.确定遍历顺序 5.举例推导dp数组
 * 纠错灵魂二问： 1.dp数组打印出来了吗？跟自己预想的哪里有出入？ 2.自己举例推导状态转移方程了吗？
 * 斐波那契数列： f(n) = f(n-1) + f(n-2)
 * @author: HammerRay
 * @date: 2024/5/6 下午9:01
 */
public class Fib {
    public int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

}
