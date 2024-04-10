package lcode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/9 下午5:10
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s){
        if("".equals(s)){
            return "";
        }
        int length = s.length();
        String res = "";
        while (length > 1){
            // substring()左开右闭
            for (int i = 0,j = i+length; j <= s.length(); i++,j++) {
                res = s.substring(i,j);
                if(reversedSame(res)){
                    return res;
                }
            }
            length--;
        }
        return String.valueOf(s.charAt(0));
    }
    public static boolean reversedSame(String s){
        StringBuilder stringBuilder =new StringBuilder(s);
        return s.contentEquals(stringBuilder.reverse());
    }
    public static String longestPalindromeDp(String s){
        // dp[i][j] 如果dp[i+1][j-1]是回文串，当s.charAt[i]==s.charAt[j]时候，dp[i][j]也是回文串
        //如果s的长度是1，则肯定是回文
        if(s.length() < 2){
            return s;
        }
        //1.构建动态规划图
        int len = s.length();
        boolean [][]dp = new boolean[len][len];
        // 字符串长度为1肯定是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 一斜排一斜排补全dp矩阵 ,即当字符串长度从2 到 3 到 4中，坐标表示的字符串是否是回文串
        int maxLen = 0;
        int begin = 0;
        char []arr = s.toCharArray();
        for(int cLen = 2; cLen < len;cLen++){
            for (int i = 0; i < len - cLen; i++) {
                int j = i+cLen-1;
                if(j >= len){
                    break;
                }
                if(arr[i] != arr[j]){
                    dp[i][j] = false;
                }else {
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1 >maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(LongestPalindrome.longestPalindrome(s));
//        System.out.println(reversedSame("bab"));
//        System.out.println("aabbccc".substring(1,3));
    }
}
