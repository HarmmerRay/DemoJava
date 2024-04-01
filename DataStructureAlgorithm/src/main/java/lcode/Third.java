package lcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/20 下午8:30
 */
public class Third {
    public static int lengthOfLongestSubstring(String s){
        if(s.isEmpty()){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int maxLength = 0;
        int slowPtr = 0;
        int i = 1;
        for(;i < s.length();i++){
            for(int j = slowPtr; j < i;j++){
                if (s.charAt(i) == s.charAt(j)){
                    if(maxLength < (i - slowPtr)){
                        maxLength = i - slowPtr;
                    }
                    slowPtr += i + 1;
                    break;
                }
            }
            if(i - slowPtr > maxLength){
                maxLength = (i - slowPtr)+1;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringTwo(String s) {
        // 与自己的期待 与他人对比都差的很远！ 扎下身体干吧  数据结构 算法 语言 工具

        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));

    }
}
