//package 类和对象.拷贝;
//
///**
// * @description:
// * @author: HammerRay
// * @date: 2024/3/4 上午8:01
// */
//public class ShallowCopy {
//    public static void main(String[] args) throws CloneNotSupportedException {
//        Person person1 = new Person();
//        person1.name = "John";
//        person1.address = new Address();
//        person1.address.city = "New York";
//
//        Person person2 = (Person) person1.clone();
//
//        // false 拷贝的是引用 不是对象  所以 引用不同
//        System.out.println(person1 == person2);
//        // true    引用指向的对象相同
//        System.out.println(person1.address == person2.address);
//    }
//}
//
//class Person implements Cloneable {
//    String name;
//    Address address;
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//}
//
//class Address {
//    String city;
//}