package carl.greedy;

import java.util.Arrays;

/**
 * @description:  尝试局部最优解 推 全局最优解，找到局部最优解。若可能不成立用 反证法 想一下。
 * 胃口值，从小到大排序。 饼干，从小到大排序。  每次都尝试把最小的饼干分给胃口最小的小孩，饼干不够大就用下一个饼干。
 * 本题的局部最优就是：每次都用最小的可以使用的饼干满足胃口最小的小孩。  尽可能地
 * @author: HammerRay
 * @date: 2024/5/7 下午8:46
 */
public class DistributeCookies {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0 || g.length == 0){
            return 0;
        }
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for(int i = 0; i < g.length; i++){
            for(int j = index; j < s.length; j++){
                if(s[j] >= g[i]){
                    index = j+1;
                    result++;
                    break;
                }
            }
            if(index >= s.length){break;}
        }

        return result;
    }
}
