package lcode;

/**
 * @description: 88.合并两个有序数组 非递减的
 * @author: HammerRay
 * @date: 2024/3/4 上午10:18
 */
public class EightyEight {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
//        merge(nums1, m, nums2, n);
        int[] num1 = {0};
        int m = 0;
        int[] num2 = {1};
        int n = 1;
        mergeB(num1,m,num2,n);
    }
    public static void mergeB(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 && n != 0){
            for(int i = 0;i < n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        if(m == 0 && n == 0){
            return;
        }
        if(m != 0 && n == 0){
            return;
        }
        for(int i = n - 1,j = m - 1,k = m+n-1 ; k >= 0;){
            if(i == -1 ){
                return;
            }
            if(j == -1){
                nums1[k] = nums2[i];
                k--;
                i--;
                continue;
            }
            if(nums2[i] >= nums1[j]){
                nums1[k] = nums2[i];
                k--;
                i--;
            }else{
                nums1[k] = nums1[j];
                nums1[j] = -1;
                k--;
                j--;
            }
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        // 正向双指针 时间复杂度：O(m+n) 空复:O(m+n)
//        int[] tmp = new int[m + n];
//        if (m == 0) {
//            for (int i = 0; i < nums1.length; i++) {
//                nums1[i] = nums2[i];
//            }
//            return;
//        }
//        if (n == 0) {
//            return;
//        }
//        int a = 0, b = 0;
//        for (int i = 0; i < m + n; i++) {
//            if (b == n) {
//                tmp[i] = nums1[a];
//                a++;
//                continue;
//            }
//            if (a == m) {
//                tmp[i] = nums2[b];
//                b++;
//                continue;
//            }
//            if (nums1[a] >= nums2[b]) {
//                tmp[i] = nums2[b];
//                b++;
//
//            } else {
//                tmp[i] = nums1[a];
//                a++;
//            }
//        }
//        for (int i = 0; i < nums1.length; i++) {
//            nums1[i] = tmp[i];
//        }
        // 逆向双指针 T:O(m+n) S:O(1)

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }
        if (n == 0) {
            return;
        }   

        for (int i = (m + n) - 1; i >= 0; i--) {
            if (m == 0) {
                nums1[i] = nums2[n - 1];
                n--;
                continue;
            }
            if (n == 0) {
                nums1[i] = nums1[m - 1];
                m--;
                continue;
            }

            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }

    }
}
