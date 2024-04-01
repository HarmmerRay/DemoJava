package lcode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/14 下午10:36
 */
public class FortyFive {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1;i++){
            // 1.插旗  2.找到当前位置a与旗b之间(a,b]可以跳到的最远距离，再次插旗。
            maxPosition = Math.max(maxPosition,i + nums[i]);
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
