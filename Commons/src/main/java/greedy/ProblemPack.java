package greedy;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 贪心算法解决背包问题
 * @author: HammerRay
 * @date: 2023/12/21 下午9:53
 */
public class ProblemPack {
    //TODO static和非static的区别
    public static void main(String[] args) {
        int capacity = 10;
        int num = 5;
        int[] weight = {1,2,3,4,5};
        int[] value = {5,4,3,2,1};

        answerPrint(capacity,num,weight,value);
    }

    private static TreeMap<Float, Integer> sort(int capacity, int number, int[] weight, int[] value) {
        //TODO TreeMap为什么只能用类类型？ TreeMap底层数据结构 算法
        TreeMap<Float, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < number; i++) {
            treeMap.put((float)value[i]/(float) weight[i],i);
        }
        return treeMap;
    }

    private static void answerPrint(int capacity, int number, int[] weight, int[] value) {
        int bestValue = 0;
        float[] bestAnswer = new float[number];
        TreeMap<Float, Integer> treeMap = sort(capacity, number, weight, value);
        //存储 <单位价值,下标>
        //TODO TreeMap的继承关系图

        Iterator<Map.Entry<Float, Integer>> i = treeMap.descendingMap().entrySet().iterator();
        while (i.hasNext()) {
            int index = i.next().getValue();
            if (capacity >= weight[index]) {
                capacity -= weight[index];
                bestValue += value[index];
                bestAnswer[index] = 1;
            } else {
                if(capacity != 0){
                    bestValue += (int) (i.next().getKey() * capacity);
                    bestAnswer[index] = (float) capacity / (float) weight[index];
                }
                bestAnswer[index] = 0;
            }
        }


        System.out.print("最优值:"+bestValue+"最优解:[");
        if(bestAnswer[0] != (int) bestAnswer[0]){
            System.out.print(bestAnswer[0]);
        }else {
            System.out.print((int)bestAnswer[0]);
        }

        for (int j = 1; j < bestAnswer.length; j++) {
            if(bestAnswer[j] != (int) bestAnswer[j]){
                System.out.print(","+bestAnswer[j]);
            }else {
                System.out.print(","+(int) bestAnswer[j]);
            }

        }

        System.out.println("]");
    }
}
