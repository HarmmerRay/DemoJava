package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("Hello world!");
        // 创建一个Date对象
        Date date = new Date();

        // 创建SimpleDateFormat对象，用于格式化日期和时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 使用SimpleDateFormat将Date转换为字符串
        String datetimeString = sdf.format(date);
        String dateBorn = simpleDateFormat.format(simpleDateFormat.parse("2003-9-10"));
        // 打印转换后的datetime字符串
        System.out.println("转换后的datetime值: " + datetimeString);
        String bornDayString = "2003-09-10";
        Date date1 = simpleDateFormat.parse(bornDayString);
        System.out.println(date1.getTime());
        System.out.println(new Date(date1.getTime()));
        System.out.println(dateBorn);
        // 现在，你可以将datetimeString插入到MySQL数据库中的datetime列中
        // 例如，你可以使用JDBC执行SQL语句来实现这一点
    }
}