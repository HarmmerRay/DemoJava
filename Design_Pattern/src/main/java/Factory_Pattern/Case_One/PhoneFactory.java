package Factory_Pattern.Case_One;

/**
 * @projectName: DemoJava
 * @package: Factory_Pattern
 * @className: PhoneFactory
 * @author: HammerRay
 * @description: TODO
 * @date: 3/2/2024 6:05 PM
 * @version: 1.0
 */

public class PhoneFactory {
    public static Phone produce(String type) {
// TODO 在此加一个List<HashTable>
// 如PhoneType.APPLE :HashTable("苹果手机","iphone","IPHONE","Iphone","苹果")等都能识别为PhoneType
        // 但是这样查找得从第一个list[0]元素开始顺序找整个hash表  效率低下
        // 可以使用 基数树RadixTree
        switch (type) {
            case "iphone":
                return new ApplePhone();
            case "huawei":
                return new HuaweiPhone();
            case "xiaomi":
                return new XiaomiPhone();
            default:
                return null;
        }

    }

}
