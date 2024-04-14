package lcode;

import java.util.Stack;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/14 下午3:56
 */
public class IsValid {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
