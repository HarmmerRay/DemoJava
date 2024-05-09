package carl.hashtable;


/**
 * @description: 自定义Hash表  用来复习hash表  此为miniHashTable (没有hash碰撞的拉链法处理)
 * 当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法。
 * @author: HammerRay
 * @date: 2024/5/8 下午8:07
 */
public class MyHashtable {
    private final int DEFAULT_CAPACITY = Integer.MAX_VALUE / 2;
    private final int[] hashTable;

    /**
     * description: 根据val计算hash的key
     *
     * @param val:
     * @paramType [int]
     * @returnType: int  返回index下标
     * @author: GodHammer
     * @date: 2024-05-08 下午9:00
     */
    private int hash(int val) {

        int result = val;
        result *= 520;
        result *= 1314;
        result = result << 3;
        result += 299;
        result %= this.DEFAULT_CAPACITY;
        return result - 1;
    }

    public MyHashtable() {
        this.hashTable = new int[DEFAULT_CAPACITY];
    }

    /**
     * description:
     *
     * @param val:
     * @paramType [int]
     * @returnType: int 元素下标
     * @author: GodHammer
     * @date: 2024-05-08 下午8:18
     */
    private int insert(int val) {
        int index = hash(val);
        hashTable[index] = val;
        return index;
    }

    /**
     * description:
     * @param val:
     * @paramType [int]
     * @returnType: int 元素下标
     * @author: GodHammer
     * @date: 2024-05-08 下午8:18
     */
    private int remove(int val) {
        //先用search查，查到就删，查不到不删

        int index = search(val);
        if(index == -1) {throw new IndexOutOfBoundsException("您提供的val不在hashtable中");}
        else {hashTable[index] = 0;return index;}
    }

    /**
     * description:
     * @param newVal:
     * @param oldVal:
     * @paramType [int, int]
     * @returnType: int 元素下标
     * @author: GodHammer
     * @date: 2024-05-08 下午8:18
     */
    private int update(int newVal, int oldVal) {
        int index = search(oldVal);
        if(index == -1) {throw new IndexOutOfBoundsException("您提供的val不在hashtable中");}
        else {hashTable[index] = newVal;return index;}
    }

    /**
     * description:
     * @param val:
     * @paramType [int]
     * @returnType: int 搜索到的元素下标即key
     * @author: GodHammer
     * @date: 2024-05-08 下午8:18
     */
    private int search(int val) {
        int index = hash(val);
        if(hashTable[index] == val) {return index;}
        else {return -1;}
    }
}
