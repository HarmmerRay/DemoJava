package carl.array;

/**
 * @description: C++中二维数组的存储空间是连续的，可以直接打印出来,而java中二维数组不得而知，java不暴露给用户数据的真实物理地址，给的是虚拟机处理过的地址。
 * 数组的元素不能删除只能修改。
 * @author: HammerRay
 * @date: 2024/5/7 下午9:16
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int result = -1;
        if (nums == null || nums.length == 0) {return -1;}
        if (nums.length == 1) {if(nums[0] == target) return 0;else return -1;}
        result = binarySearch(nums,target,0,nums.length-1);
        return result;
    }
    private int binarySearch(int[] nums, int target,int begin,int end) {
        if(begin >= end) {if(nums[begin] == target) {return begin;}else {return -1;}}
        int mid = (begin+end)/2;
        if(nums[mid] == target){
            return mid;
        }else if (nums[mid] > target) {
            return binarySearch(nums,target,begin,mid-1);
        }else {
            return binarySearch(nums,target,mid+1,end);
        }
    }
}
