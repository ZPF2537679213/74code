package org.example;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *https://mvnrepository.com/
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        MysqlDataSource dataSourse=new MysqlDataSource();
        dataSourse.setUrl("jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false");
        dataSourse.setUser("root");
        dataSourse.setPassword("123456");
        Connection con=dataSourse.getConnection();
        String mysql="select * from student4 where id=?";
        PreparedStatement statement=con.prepareStatement(mysql);
        statement.setInt(1,1);
        ResultSet resultSet=statement.executeQuery();
        if(resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        statement.close();
        con.close();
    }
}
