import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;


/**
 * @description:
 * @author: HammerRay
 * @date: 2023/11/7 下午5:52
 */
public class BasicDataTypes {

    public static void main(String[] args) {

        //1字节
        byte a = 127;
        //2字节
        short b = 3;
        //4字节
        int c = 3;
        //1字节
        char d = 3;
        //8字节
        long e = 3;
        //4字节
        float f = 2;
        //8字节
        double g = 3;
        //1位
        boolean h = true;


        System.out.println("Size of byte: " + ObjectSizeCalculator.getObjectSize(a));
        System.out.println("Size of short: " + ObjectSizeCalculator.getObjectSize(b));
        System.out.println("Size of int: " + ObjectSizeCalculator.getObjectSize(c));
        System.out.println("Size of long: " + ObjectSizeCalculator.getObjectSize(d));
        System.out.println("Size of float: " + ObjectSizeCalculator.getObjectSize(e));
        System.out.println("Size of double: " + ObjectSizeCalculator.getObjectSize(f));
        System.out.println("Size of char: " + ObjectSizeCalculator.getObjectSize(g));
        System.out.println("Size of boolean: " + ObjectSizeCalculator.getObjectSize(h));

        System.out.println("Size of byte: " + ClassLayout.parseClass(byte.class).toPrintable());
        System.out.println("Size of short: " + ClassLayout.parseClass(short.class).toPrintable());
        System.out.println("Size of int: " + ClassLayout.parseClass(int.class).toPrintable());
        System.out.println("Size of long: " + ClassLayout.parseClass(long.class).toPrintable());
        System.out.println("Size of float: " + ClassLayout.parseClass(float.class).toPrintable());
        System.out.println("Size of double: " + ClassLayout.parseClass(double.class).toPrintable());
        System.out.println("Size of char: " + ClassLayout.parseClass(char.class).toPrintable());
        System.out.println("Size of boolean: " + ClassLayout.parseClass(boolean.class).toPrintable());
    }

}
