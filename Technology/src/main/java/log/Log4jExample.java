package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * @description:
 * @author: HammerRay
 * @date: 2023/11/3
 */
public class Log4jExample {
    private static final Logger logger = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        // 记录不同级别的日志消息
        logger.trace("This is a TRACE message");
        logger.debug("This is a DEBUG message");

        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
        logger.fatal("This is a FATAL message");

        // 通过占位符记录日志
        String name = "John";
        int age = 30;
        logger.info("User '{}' is {} years old.", name, age);

        // 使用异常信息记录日志
        try {
            // 引发一个异常
            int result = 1 / 0;
        } catch (Exception e) {
            logger.error("An error occurred:", e);
        }
    }
}
