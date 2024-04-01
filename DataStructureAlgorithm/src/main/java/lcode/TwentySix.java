package lcode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/7 上午10:47
 */
public class TwentySix {
    public static int removeDuplicates(int[] nums) {
        // 暴力破解
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                for (int j = i+1; j < length; j++) {
                    nums[j-1] = nums[j];
                }
                length--;
                i--;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int k = removeDuplicates(nums);

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
        }
    }

}
