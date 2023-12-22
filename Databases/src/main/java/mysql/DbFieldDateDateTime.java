package mysql;

import javafx.beans.binding.ObjectExpression;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/11/12 下午7:53
 */
public class DbFieldDateDateTime {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","000000");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into date_datetime (date1,date2) values (?,?)");
//        preparedStatement.setString(1, "2003-09-10");   //String与Date都可以与 数据库中的date类型相匹配
//        preparedStatement.setDate(1,new Date(System.currentTimeMillis() - 5));
        preparedStatement.setString(1, "2003-09-10");
        preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
//        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));  //找到了 Parameter index out of range (3 > number of parameters, which is 2).

//        preparedStatement.setString(3,"ssss");   //为了找到 java.sql.SQLException: Parameter index out of range (17 > number of parameters, which is 16). 这种错误
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Failed to insert data.");
        }

    }
}
