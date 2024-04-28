package header;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description: 8个字节一对齐，即32位
 * @author: HammerRay
 * @date: 2024/4/26 下午10:04
 */
public class ObjectHead {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        User user = new User();
        User[]users = new User[10];
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println(ClassLayout.parseInstance(users).toPrintable());
    }
}
