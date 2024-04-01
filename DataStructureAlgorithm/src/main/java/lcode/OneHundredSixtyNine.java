package lcode;

import java.util.TreeMap;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/9 上午9:42
 */
public class OneHundredSixtyNine {
    public static int majorityElement(int[] nums) {
        // TreeMap 遍历赋值 排序  比较 暴力破解
        int judgeLine = nums.length / 2;
        System.out.println(judgeLine);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int j : nums) {
            map.merge(j, 1, Integer::sum);
        }
        for (Integer integer : map.descendingKeySet()) {
            int num = (int) integer;
            System.out.println(map.get(num));
            if (map.get(num) > judgeLine) {
                return num;
            }
        }

        return 1;
    }

    public static int majorityElementTwo(int[] nums) {
        //  这个方法牛，已知数组中肯定有多数元素，然后就定义两个变量，一个变量V记录数值，一个变量M记录次数，让变量M随遇而安地增减，值相同就＋，不同就-。
        //  但是V的值只有当,M到零的时候才会改变，就是说只有当有足够数量的其它数与V出现的次数相同时，V才会改变数值。
        int r = 0, v = 0;
        for (int i = 0; i < nums.length; i++) {
            if (v == 0) {
                r = nums[i];
                v++;
            } else if (r == nums[i]) {
                v++;
            } else {
                v--;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 3, 4};

        System.out.println(majorityElementTwo(nums));
    }
}
