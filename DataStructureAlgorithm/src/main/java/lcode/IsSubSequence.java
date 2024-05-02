package lcode;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/5/2 下午11:35
 */
public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
