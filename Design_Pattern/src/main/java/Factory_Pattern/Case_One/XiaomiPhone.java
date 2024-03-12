package Factory_Pattern.Case_One;

/**
 * @projectName: DemoJava
 * @package: Factory_Pattern
 * @className: XiaomiPhone
 * @author: HammerRay
 * @description: TODO
 * @date: 3/2/2024 5:54 PM
 * @version: 1.0
 */

public class XiaomiPhone implements Phone{
    @Override
    public void call() {
        System.out.println("小米手机呼叫~~~");;
    }
}