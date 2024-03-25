package designPattern.One_FactoryPattern.Case_One;

/**
 * @projectName: DemoJava
 * @package: Factory_Pattern
 * @className: HuaweiPhone
 * @author: HammerRay
 * @description: TODO
 * @date: 3/2/2024 5:54 PM
 * @version: 1.0
 */

public class HuaweiPhone implements Phone{
    @Override
    public void call() {
        System.out.println("华为手机呼叫~~~");;
    }
}