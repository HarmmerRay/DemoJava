package json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description: Json->Java对象 java对象->Json
 * @author: HammerRay
 * @date: 2024/4/22 下午6:47
 */
public class JsonAnalyse {

    public static void main(String[] args) {
        String json = "{\"name\":\"张三\",\"age\":30}";
        System.out.println(json);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Person person = objectMapper.readValue(json, Person.class);

            System.out.println("姓名：" + person.getName());
            System.out.println("年龄：" + person.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
