package annotation;

import java.lang.annotation.*;

@Documented
@Inherited
// ElementType.TYPE: 应用于类、接口（包括注解类型）、枚举
// ElementType.FIELD: 应用于属性（包括枚举中的常量）
// ElementType.METHOD: 应用于方法
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DiyTest {
    String value() default "";
}

