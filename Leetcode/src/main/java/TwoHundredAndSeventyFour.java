import java.util.Arrays;

/**
 * @projectName: DemoJava
 * @package: PACKAGE_NAME
 * @className: TwoHundredAndSeventyFour
 * @author: HammerRay
 * @description: TODO
 * @date: 3/15/2024 10:38 PM
 * @version: 1.0
 */

public class TwoHundredAndSeventyFour {
    public int hIndex(int[] citations){
        // 从h值为h篇论文，h-1篇论文,最大找到最小
        for(int i = citations.length; i > 0;i--){
            int cases = 0;
            int chance = citations.length - i;
            // 从头遍历到尾一次数组，找到所有被引用次数大于等于h的元素，用cases计数。
            for(int j = 0; j <citations.length;j++){
                if(citations[j] >= i){
                    cases++;
                }else{
                    // 不符合的元素就代表机会失去一次，如果机会用完，则这个h值是不可取的。
                    chance--;
                    if(chance < 0){
                        break;
                    }
                }
            }
            if(cases >= i){
                return i;
            }
        }
        return 0;
    }
    public int hIndexTwo(int[] citations){
        int h=0;
        // 对数组进行排序，然后直接从最大开始向下，进行h与citations[i]值的比较，当citation[i]值不比h大了，得到的h是答案的h了.最少发表h篇，至少有h篇，每篇被引用了h次。
        Arrays.sort(citations);
        for (int i = citations.length-1; i >= 0; i--) {
            if(citations[i]>h){
                h++;
            }
        }
        return h;
    }
}
