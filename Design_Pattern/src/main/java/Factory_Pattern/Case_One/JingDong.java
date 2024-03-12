package Factory_Pattern.Case_One;

/**
 * @projectName: DemoJava
 * @package: Factory_Pattern
 * @className: Jd
 * @author: HammerRay
 * @description: TODO
 * @date: 3/2/2024 6:53 PM
 * @version: 1.0
 */

public class JingDong {
    public void order(String type){
        Phone phone = PhoneFactory.produce(type);
        if (phone != null){
            phone.call();
        }
    }

    public static void main(String[] args) {
        JingDong jingDong = new JingDong();
        jingDong.order("iphone");
        Taobao taobao = new Taobao();
        taobao.order("huawei");
    }
}
