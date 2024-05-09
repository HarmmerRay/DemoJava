package carl.hashtable;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/5/8 下午9:41
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        if(mapS.size() != mapT.size()){return false;}
        Iterator<Character> iterator = mapS.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = (Character) iterator.next();
            Integer valS = mapS.get(key);
            Integer valT = mapT.get(key);
            if(valS != null && valT !=null) {
                if(!valT.equals(valS)){
                    return false;
                }
            }else {
                return false;
            }

        }
        return true;
    }
    public static boolean isAnagramB(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "dcba";
        System.out.println(isAnagram(s, t));
    }
}
