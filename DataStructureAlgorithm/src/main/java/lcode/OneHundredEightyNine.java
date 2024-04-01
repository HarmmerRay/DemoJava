package lcode;

/**
 * @description: 循环向右平移n位数组元素
 * @author: HammerRay
 * @date: 2024/3/10 下午10:21
 */
public class OneHundredEightyNine {
    public static void rotate(int[] nums, int k) {
        // 新旧数组拷贝
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static void rotateTwo(int[] nums, int k) {
        // 环状替换
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public static int gcd(int x, int y) {
        //辗转相除法求最大公约数
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void rotateThree(int[] nums, int k) {
        // 数组翻转
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, (k-1));
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int begin, int end) {
        for (int i = begin, j = end; i <= (end + begin) / 2; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateThree(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(String.valueOf(nums[i]));
        }
    }

}
