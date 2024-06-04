package annotation;

/**
 * @projectName: DemoJava
 * @package: annotation
 * @className: DiyItem
 * @author: HammerRay
 * @description: TODO
 * @date: 5/29/2024 5:43 PM
 * @version: 1.0
 */

public class DiyItem {
    private String name;
    private String age;

    public String getName() {
        return name;
    }
    @DiyTest("赵阳")
    public DiyItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }
    @DiyTest("18")
    public DiyItem setAge(String age) {
        this.age = age;
        return this;
    }


}
