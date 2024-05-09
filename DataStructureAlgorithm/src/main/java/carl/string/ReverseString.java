package carl.string;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/5/8 下午10:00
 */
public class ReverseString {
    public void reverseString(char[] s) {
        // 前后指针
        for(int i = 0,j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
