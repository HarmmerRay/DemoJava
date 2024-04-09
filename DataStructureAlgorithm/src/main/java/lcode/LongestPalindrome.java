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

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(LongestPalindrome.longestPalindrome(s));
//        System.out.println(reversedSame("bab"));
//        System.out.println("aabbccc".substring(1,3));
    }
}
