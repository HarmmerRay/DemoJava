package sort;

import java.util.Arrays;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/27 下午5:34
 */
public class QuickSort implements Sort{


    @Override
    public void sort(int[] nums) {
        quickSort(nums,0,nums.length - 1);
    }
    private static void quickSort(int []nums,int left,int right){
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            // 对基准左边子数组递归排序
            quickSort(nums, left, pivotIndex - 1);
            // 对基准右边子数组递归排序
            quickSort(nums, pivotIndex + 1, right);
        }
    }
    private static int partition(int []nums,int left,int right){
        int i = left;

        for (int j = left; j < right; j++) {
            // left<= num.index <= i  是 num<flag
            // i < num.index <=j 是 num>flag
            if(nums[j] < nums[right]){
                swap(nums,i,j);
                i++;
            }
        }

        swap(nums,i,right);

        return i;
    }
    private static void swap(int []num,int l,int r){
        int tmp = num[l];
        num[l] = num[r];
        num[r] = tmp;
    }
    public static void main(String[] args) {
        int []nums = {2,3,-1,8,4};
        new QuickSort().sort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
