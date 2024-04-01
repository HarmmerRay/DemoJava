package design.pattern.One_FactoryPattern.Case_One;

/**
 * @projectName: DemoJava
 * @package: Factory_Pattern
 * @className: Taobao
 * @author: HammerRay
 * @description: TODO
 * @date: 3/2/2024 6:53 PM
 * @version: 1.0
 */

public class Taobao {
    public void order(String type){
        Phone phone = PhoneFactory.produce(type);
        if (phone != null){
            phone.call();
        }
    }
}
