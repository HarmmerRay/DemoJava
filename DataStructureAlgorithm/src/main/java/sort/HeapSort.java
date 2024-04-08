package sort;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/28 上午11:12
 */
public class HeapSort implements Sort{
    @Override
    public void sort(int[] nums) {

    }

    private static void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
