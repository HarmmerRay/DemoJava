package lcode;

/**
 * @projectName: DemoJava
 * @package: lcode
 * @className: Zconvert
 * @author: HammerRay
 * @description: TODO
 * @date: 4/17/2024 11:26 PM
 * @version: 1.0
 */

public class Zconvert {
        public String convert(String s, int numRows) {
            int n = s.length(), r = numRows;
            if (r == 1 || r >= n) {
                return s;
            }
            int t = r * 2 - 2;
            int c = (n + t - 1) / t * (r - 1);
            char[][] mat = new char[r][c];
            for (int i = 0, x = 0, y = 0; i < n; ++i) {
                mat[x][y] = s.charAt(i);
                if (i % t < r - 1) {
                    ++x; // 向下移动
                } else {
                    --x;
                    ++y; // 向右上移动
                }
            }
            StringBuffer ans = new StringBuffer();
            for (char[] row : mat) {
                for (char ch : row) {
                    if (ch != 0) {
                        ans.append(ch);
                    }
                }
            }
            return ans.toString();
        }

}
