package lcode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/6 上午9:35
 */
public class TwentySeven {
    public static int removeElement(int[] nums, int val) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 0;
                result--;
            }
        }

        int i = nums.length - 1;
        int j = 0;
        int m = 0;
        while (m < nums.length - result) {
            while (nums[j] != 0) {
                j++;
            }
            while (nums[i] == 0) {
                i--;
                if (i < 0){
                    break;
                }
            }
            if (i <= j){
                break;
            }
            nums[j] = nums[i];
            nums[i] = 0;
            m++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1};
        int len = removeElement(data, 1);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i]);
        }
    }
}
