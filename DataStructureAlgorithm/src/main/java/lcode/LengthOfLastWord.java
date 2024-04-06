package lcode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/6 下午10:51
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        boolean flag = false;
        int i = s.length();
        while(!flag){
            i--;
            if(!Character.isSpaceChar(s.charAt(i))){
                flag = true;
            }
        }
        int j = 0;
        for(; j < s.length() && i >= 0;j++,i--){
            if(Character.isSpaceChar(s.charAt(i))){
                return j ;
            }
        }
        return j;
    }

    public static void main(String[] args) {

    }
}
