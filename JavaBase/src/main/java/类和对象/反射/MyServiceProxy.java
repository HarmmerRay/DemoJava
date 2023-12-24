package 类和对象.反射;



import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/24 下午10:05
 */
interface MyService{
    void hello(int i);
}
class MyServiceImpl implements MyService{
    private String name;

    public MyServiceImpl (String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public void hello(int i ) {
        System.out.println("Hello!"+i+this.name);
    }
}

/**
 * @author zy_
 */
public class MyServiceProxy {
    private Object target;
    public MyServiceProxy(Object target){
        this.target = target;
    }
    public Object getProxyInstance() {
        ClassLoader loader = target.getClass().getClassLoader();

        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("Before hello() method execution");
                Object value = method.invoke(target, objects);
                System.out.println("After hello() method execution");
                return null;
            }
        };
        return Proxy.newProxyInstance(loader,interfaces, invocationHandler);
    }
}

// 创建一个普通类做为代理类
class Person {
    //  代理类中由普通方法
    public void eat() {
        System.out.println("我要开始吃饭咯...");
    }

    public void play() {
        System.out.println("我要出去玩耍了,,,");
    }
}

class MyApiInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("吃饭前我会先洗手"); // 此处可以做一些操作
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("吃完饭我会先休息会儿" );  // 方法调用之后也可以进行一些操作
        return result;
    }
}

class MyApiInterceptorForPlay implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("出去玩我会先带好玩具"); // 此处可以做一些操作
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("玩一个小时我就回家了" );  // 方法调用之后也可以进行一些操作
        return result;
    }
}


class CallbackFilterImpl implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (method.getName().equals("play"))
            return 1;
        else
            return 0;
    }
}
