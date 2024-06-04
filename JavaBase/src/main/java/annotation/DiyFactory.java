package annotation;

import java.lang.reflect.Method;

/**
 * @projectName: DemoJava
 * @package: annotation
 * @className: DiyFactory
 * @author: HammerRay
 * @description: TODO
 * @date: 5/29/2024 5:44 PM
 * @version: 1.0
 */

public class DiyFactory {
    public static DiyItem create(){
        DiyItem diyItem = new DiyItem();

        Method[] methods = DiyItem.class.getMethods();

        try{

            for(Method method : methods){
                // 判断此方法上空是否存在参数表示的注解类型，存在此方法返回true
                // 参数是 对应于注解类型的Class对象

                if(method.isAnnotationPresent(DiyTest.class)){
                    DiyTest diyTest = method.getAnnotation(DiyTest.class);
                    method.invoke(diyItem,diyTest.value());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return diyItem;
    }

    public static void main(String[] args) {
        DiyItem diyItem = create();
        diyItem.setAge("30");
        System.out.println(diyItem.getName());
        System.out.println(diyItem.getAge());
    }
}
