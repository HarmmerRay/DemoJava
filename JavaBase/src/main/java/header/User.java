package header;

/**
 * @description:  用来实验对象头
 * @author: HammerRay
 * @date: 2024/4/26 下午10:05
 */
public class User {
    public User(){};
    public User(String id, int age, String name, char gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    private String id;
    private int age;
    private String name;
    private char gender;
}
