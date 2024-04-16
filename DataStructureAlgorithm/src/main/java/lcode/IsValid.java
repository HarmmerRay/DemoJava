package lcode;

import java.util.*;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/14 下午3:56
 */
public class IsValid {
    private static Map<Character, Character> map = new HashMap() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
        put('?', '?');
    }};

    private static boolean isValid(String s) {
        if(!s.isEmpty() && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c: s.toCharArray()) {
            if (map.containsKey(c)){
                stack.addLast(c);
            }else if(!map.get(stack.removeLast()).equals(c)) {
                return false;
            }
        }
        
        return stack.size() == 1;
    }

    public static void main(String[] args) {
//        String s = "()";
//        System.out.println(isValid(s));
        int []nums1 = {1,2,3,4};
        int []nums2 = {2,2,2,2};
        nums1 = nums2;
        for (Integer i:nums1) {
            System.out.println(i);
        }
    }
}
