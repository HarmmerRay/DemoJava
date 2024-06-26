package lcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: LeetCode1
 * @author: HammerRay
 * @date: 2024/4/8 上午8:58
 */
public class TwoSum {
    public int[] twoSum(int []nums,int target){

        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if((nums[i] + nums[j]) == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[2];
    }
    public int[] twoSumB(int []nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

}
