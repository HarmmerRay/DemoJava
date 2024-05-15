package carl.array;

/**
 * @projectName: DemoJava
 * @package: carl.array
 * @className: SortedSquares
 * @author: HammerRay
 * @description: TODO
 * @date: 5/15/2024 11:38 PM
 * @version: 1.0
 */

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if((nums[i] * nums[i]) > (nums[i + 1] * nums[i + 1] )) {
                int tmp = nums[i];
                nums[i] = (nums[i+1] * nums[i + 1]);
                nums[i+1] = tmp;
            }else {
                nums[i] = (nums[i] * nums[i]);
            }

        }
        return nums;
    }
    public int[] sortedSquaresB(int[] nums) {

        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
