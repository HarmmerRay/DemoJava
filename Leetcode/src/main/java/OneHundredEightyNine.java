/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/10 下午10:21
 */
public class OneHundredEightyNine {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(String.valueOf(nums[i]));
        }
    }

}
