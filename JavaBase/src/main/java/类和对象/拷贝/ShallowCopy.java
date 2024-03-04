package 类和对象.拷贝;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/4 上午8:01
 */
public class ShallowCopy implements Cloneable {
    String name;
    String address;
    @Override
    protected Object clone() {
        return super.clone();
    }
}
