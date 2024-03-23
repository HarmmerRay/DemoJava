import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/23 下午3:13
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // 快速排序 归并排序后 直接取nums[k]
//        quickSort(nums);
        mergeSort(nums);
        return nums[k];
    }
    private void quickSort(int []nums){

            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            List<Integer> myNums = new ArrayList<>(nums);
    }
    private void mergeSort(int []nums){

    }
}
