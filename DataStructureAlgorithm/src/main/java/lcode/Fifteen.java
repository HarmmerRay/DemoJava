package lcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 三数之和等于0
 * @author: HammerRay
 * @date: 2024/4/1 下午10:14
 */
public class Fifteen {
    private int x,y,z;
    private List<List<Integer>> result = new ArrayList<>();
    private void judge(int[] nums){
        List<Integer> element = new ArrayList<>();
        if(nums[x]+nums[y]+nums[z] == 0){
            element.add(nums[x]);
            element.add(nums[y]);
            element.add(nums[z]);
            result.add(element);
        }
    }
    private int[] deduplication(int []nums){
        // 使用HashSet来存储不重复的数字
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 将不重复的数字转换回数组
        int[] uniqueArray = new int[set.size()];
        int index = 0;
        for (int num : set) {
            uniqueArray[index++] = num;
        }
        return uniqueArray;
    }
    public List<List<Integer>> threeSum(int[] nums) {
//        nums = deduplication(nums);

        int length = nums.length;
        // len = 5  len - 2 = 3
        // index 0 1 2 3 4
        // value 1 2 3 4 5
        while(y < length - 1){
            for(z=y+1;z < length;z++){
                judge(nums);
            }
            y++;
        }
        z--;
        y--;
        System.out.println(y+" "+z);
        for(x=1;x < length - 2;x++){
            judge(nums);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums ={0,0,0};
        new Fifteen().threeSum(nums);
    }
}
