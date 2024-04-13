package lcode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/12 下午11:15
 */
public class LongestCommonPrefix {
        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String result = strs[0];
            for(int i = 1;i < strs.length; i++){
                result = longest(result,strs[i]);
            }
            return result;
        }

        private static String longest(String longest,String now){
            int length = Math.min(longest.length(), now.length());
            int pos = 0;
            for(int i =0; i < length;i++){
                pos = i;
                if(longest.charAt(i) != now.charAt(i)){
                    break;
                }
            }
            return longest.substring(0,pos);
        }

    public static void main(String[] args) {
        String []strs = {"flower","flow","flight"};
        System.out.println(strs[0].charAt(0) == strs[1].charAt(0));
        System.out.println(longestCommonPrefix(strs));
    }
}
