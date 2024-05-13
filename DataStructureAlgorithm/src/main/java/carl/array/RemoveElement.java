package carl.array;

/**
 * @description: LC.27  此问题与GC中标记整理算法相似
 * @author: HammerRay
 * @date: 2024/5/13 下午8:20
 */
public class RemoveElement {
    /**
     * description:  时间复杂度是考虑最坏情况的时间复杂度，时间复杂度为： O(n^2)  即 n-1 + n-2 + n-3 + .... + 1 = n*(n-1)/2
     * @paramType [int[], int]
     * @param nums:
     * @param val:
     * @returnType: int
     * @author: GodHammer
     * @date: 2024-05-13 下午8:58
     */
    public int removeElement(int[] nums, int val){

        // [3,2,2,3]
        // 每次移除一个元素，则从最后一位元素开始找起，不等于value则补充上去.

        int lastIndex = nums.length - 1;
        for (int i = 0; i <= lastIndex; i++) {  // 注意：i <= 的 等号
            if(nums[i] == val){
                for (int j = lastIndex; j >= i ; j--){ // 注意： j >= i 的等号
                    if(nums[j] != val){
                        nums[i] = nums[j];
                        lastIndex--;
                        break;
                    }
                    lastIndex--;
                }
            }
        }
        return lastIndex+1;
    }
    /**
     * description: 同方向双指针法  时间复杂度为n 空间复杂度为1
     * @paramType [int[], int]
     * @param nums:
     * @param val:
     * @returnType: int
     * @author: GodHammer
     * @date: 2024-05-13 下午9:00
     */
    public int removeElementB(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            if(val != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
