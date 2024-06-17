package clazz.anonymous;

/**
 * @projectName: DemoJava
 * @package: clazz.anonymous
 * @className: OuterClass
 * @author: HammerRay
 * @description: 匿名内部类常用于实现一个接口或继承一个类，并且只需要用一次.如多线程中的new Runnable(){};Swing GUI中的jButton.addActionListener(new ActionListener(){});
 * @date: 6/5/2024 7:49 AM
 * @version: 1.0
 */

interface BaseInterface{
    void doSomething();
}

public class OuterClass {
    public void methodInheritance(){
        BaseClass baseClass = new BaseClass(){
            @Override
            public void baseMethod() {
                System.out.println("OuterClass:BaseMethod");
            }

            public void additionalMethod(){
                System.out.println("additional method");
            }
        };
        baseClass.baseMethod();
//        baseClass.additionalMethod();
    }
    public void methodImplementation(){
        BaseInterface baseInterface = new BaseInterface() {
            @Override
            public void doSomething() {
                System.out.println("BaseInterface:doSomething");
            }
        };
        baseInterface.doSomething();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.methodInheritance();
    }
}
