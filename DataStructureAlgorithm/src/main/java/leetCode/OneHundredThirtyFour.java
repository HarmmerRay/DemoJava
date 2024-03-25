package leetCode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/18 上午8:28
 */
public class OneHundredThirtyFour {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        boolean flag = false;
        int gasRemain = 0;
        for (int i = 0; i < length; i++) {
            gasRemain += gas[i];
            if(gasRemain <= 0){
                continue;
            }
            if (cost[i] <= gasRemain) {
                gasRemain -= cost[i];
                flag = true;
                for (int j = i + 1; j % length != i; j++) {
                    gasRemain += gas[j % length];
                    if (cost[j % length] > gasRemain) {
                        flag = false;
                        gasRemain = 0;
                        break;
                    }
                    gasRemain -= cost[j % length];
                }
            }else {
                gasRemain = 0;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
    public static int canCompleteCircuitOne(int[] gas, int[] cost) {
        // 精彩！  复杂问题简单化  就是遍历一遍所有的值，只要是油在哪里耗尽就以哪里作为起点，继续向下找，无需循环，因为就算是循环该在哪里没油还是在那里没有。
        // 这样保存到最后的start就是起始点
        int len = gas.length;
        int sum = 0,tmp = 0,start = 0;
        for(int i=0; i < len; i++){
            sum += gas[i] - cost[i];
            if(sum < tmp){
                tmp = sum;
                start = (i+1)%len;
            }
        }
        return sum<0 ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = {3,3,4};
        int[] cost = {3,4,4};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
