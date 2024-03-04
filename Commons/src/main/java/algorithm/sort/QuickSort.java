package algorithm.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/27 下午5:34
 */
public class QuickSort {
    private static void quickSortA(int[] arr,int left,int right){
        if(right - left <= 1){
            return;
        }else {
            //选取参考值
            int flag = arr[right];
            int i =0;
            //方法一: 前后指针
            for (int j=1; j <= right; j++){
                //小于等于flag就交换位置 直到最后j直到flag位置的值与++i进行交换，执行完第一次的快速排序
                if(arr[j] <= flag){
                    int tmp = arr[++i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            quickSortA(arr,1,i-1);
            quickSortA(arr,i+1,right);
        }

    }

    public static void quickSortB(int[] arr,int left,int right){
        if(right - left == 0){
            return;
        }
        //方法二：左右指针数值交换
        //基准值
        int flag = arr[left];
        int i = left ;
        int j = right;
        for(;j >= i;j--){
            if(arr[j] <= flag){
                //若找的时候与i碰面则跳出循环
                if(j == i){
                    int tmp = arr[j];
                    arr[j] = arr[left];
                    arr[left] = tmp;
                }else {
                    i++;
                    boolean f = false;
                    //找到大于基准值的元素
                 while (arr[i] <= flag){
                     if(j == i) {
                         int tmp = arr[j];
                         arr[j] = arr[left];
                         arr[left] = tmp;
                         f = true;
                         break;
                     }
                 }
                 //如果找的时候与j碰面了则，跳出循环
                if(f){
                    break;
                } else {
                    int tmp = arr[right];
                    arr[right] = arr[i];
                    arr[i] = tmp;
                }

                }
            }
        }
        if(i == j){
            quickSortB(arr,left,i-1);
            quickSortB(arr,i+1,right);
        }else {
            System.out.println(" "+ i+" "+j +" " + Arrays.toString(arr));
            System.out.println("错误：左右指针汇合的时候出错啦");
        }

    }

    public static void quickSortC(int[] arr,int left,int right){
        //方法三：左右指针挖坑法 (递归&非递归)
    }
    public static void main(String[] args) {
        int[] initArr = {0,3,51,25,-1,5231,521};
        System.out.println("原始:"+Arrays.toString(initArr));
        // [0,6]
//        quickSortA(initArr,1,initArr.length-1);
//        System.out.println("排序后"+Arrays.toString(initArr));
        quickSortB(initArr,1,initArr.length-1);
        System.out.println("排序后"+Arrays.toString(initArr));
    }
}
