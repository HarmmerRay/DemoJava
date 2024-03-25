package leetCode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/8 下午11:31
 */
public class Eighty {
    public static int removeDuplicates(int[] nums) {
        // 快慢双指针的身为差
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[slow - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;

    }

    public static void main(String[] args) {
        int [] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int length = removeDuplicates(nums);
        for (int i = 0;i < length;i++){
            System.out.println(nums[i]);

        }
    }
}
