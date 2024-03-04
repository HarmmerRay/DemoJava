package 类和对象.拷贝;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/3/4 上午8:01
 */
public class DeepCopy {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "John";
        person1.address = new Address();
        person1.address.city = "New York";

        Person person2 = person1.deepCopy();
        // 引用地址不相同 false
        System.out.println(person2 == person1);
        // 引用地址指向的对象也不相同 false
        System.out.println(person2.address == person1.address);
    }
}

class Person implements Serializable{
    String name;
    Address address;
    /**
     * description: 用序列化和反序列化实现深拷贝 ，Person类实现Serializable 接口
     * @paramType []
     * @returnType: 类和对象.拷贝.Person
     * @author: GodHammer
     * @date: 2024-03-04 上午8:41
     */
    public Person deepCopy(){
        return SerializationUtils.clone(this);
    }
}
class Address implements Serializable{
    String city;
}