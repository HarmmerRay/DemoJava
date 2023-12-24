package 类和对象.反射;

import org.junit.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/24 下午10:46
 */
public class MyTest {

    @Test
    public void jdkProxyTest(){
        MyService target = new MyServiceImpl("zy");
        System.out.println("目标对象信息:"+target.getClass());
        target.hello(1);
        MyService proxy = (MyService) new MyServiceProxy(target).getProxyInstance();
        System.out.println("代理对象信息:"+proxy.getClass());
        proxy.hello(1);
    }
    @Test
    public void cglibProxyTest(){
        Callback[] callbacks = new Callback[]{new MyApiInterceptor(),new MyApiInterceptorForPlay()};
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new CallbackFilterImpl());
        Person person = (Person) enhancer.create();

        person.eat();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
        person.play();
    }
}
