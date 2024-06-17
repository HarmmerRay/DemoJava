package log;

import lombok.extern.slf4j.Slf4j;


/**
 * @projectName: DemoJava
 * @package: log
 * @className: Slf4jExample
 * @author: HammerRay
 * @description: TODO
 * @date: 6/5/2024 12:45 AM
 * @version: 1.0
 */
@Slf4j
public class Slf4jExample {
    public void slf4jTest() {
        try{
            log.info("Hello World");
            System.out.println("正常执行");
        }catch (Exception e){
            log.error(e.getMessage());
            System.out.println("执行错误");
        }

    }

    public static void main(String[] args) {
        new Slf4jExample().slf4jTest();
    }
}

