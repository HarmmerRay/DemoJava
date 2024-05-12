package carl.array;

/**
 * @projectName: DemoJava
 * @package: carl.array
 * @className: MaxArea
 * @author: HammerRay
 * @description: TODO
 * @date: 5/12/2024 10:46 PM
 * @version: 1.0
 */

public class MaxArea {
    public int maxArea(int[] height){
        int l = 0, r = height.length - 1;
        int result  = 0;
        while (l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            result = Math.max(result, area);
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return result;
    }
}
