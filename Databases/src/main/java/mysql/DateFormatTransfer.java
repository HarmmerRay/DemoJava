package mysql;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/11/13 下午9:28
 */
public class DateFormatTransfer {
    public static void main(String[] args) {

        //两种Date
        //数据库Date  数据库date属性对应此Date
        java.sql.Date date1 = new Date(System.currentTimeMillis());
        //java程序Date
        java.util.Date date2 = new java.util.Date();

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //java.sql.Date使用例子
        //user1.setUserBornDay(new java.sql.Date(sdf1.parse("2003-09-10").getTime()));
        //java.sql.TimeStamp使用例子  对应数据库的time属性 和 timestamp属性
        //user1.setUserCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));
    }
}
