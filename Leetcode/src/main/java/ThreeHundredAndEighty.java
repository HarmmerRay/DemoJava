import java.util.*;

/**
 * @description: 变长数组加上HashTable实现插入、删除、查找数据时间复杂度O(1)
 * @author: HammerRay
 * @date: 2024/3/16 下午10:59
 */
public class ThreeHundredAndEighty {
        List<Integer> nums;
        Map<Integer, Integer> indices;
        Random random;

        public ThreeHundredAndEighty() {
            nums = new ArrayList<Integer>();
            indices = new HashMap<Integer, Integer>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            nums.add(val);
            indices.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }
            int index = indices.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            indices.put(last, index);
            nums.remove(nums.size() - 1);
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(nums.size());
            return nums.get(randomIndex);
        }

}
