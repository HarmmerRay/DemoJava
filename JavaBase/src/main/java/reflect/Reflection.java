package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/24 上午8:24
 */
public class Reflection {
    private int id;
    public void setId (int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //正射
        Reflection reflection = new Reflection();
        reflection.setId(1);
        System.out.println("正射调用过程Reflection id:" + reflection.getId());

        //反射 三种：Class.forName("包名.类名")  类名.class  new 类名().getClass
        //类加载器双亲委派模型 SelfDefinition ClassLoader --> Application ClassLoader --> Extension ClassLoader --> Bootstrap ClassLoader
        Class clz = Class.forName("reflect.Reflection");
        Constructor reflectionConstructor = clz.getConstructor();
        Object reflectionObj = reflectionConstructor.newInstance();

        Method setIdMethod = clz.getMethod("setId",int.class);
        setIdMethod.invoke(reflectionObj,2);
        Method getIdMethod = clz.getMethod("getId");
        System.out.println("反射调用过程Reflection id:" + getIdMethod.invoke(reflectionObj));
    }
}
