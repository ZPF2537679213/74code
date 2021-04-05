package utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
    private static MysqlDataSource dataSource = null;
    public static Connection dataSourse() throws SQLException {
            if(dataSource==null){
                dataSource=new MysqlDataSource();
                String url="jdbc:mysql://127.0.0.1:3306/javainfor?charactionEncoding=utf-8&useSSL=true";
                String user="root";
                String password="123456";
                dataSource.setUrl(url);
                dataSource.setUser(user);
                dataSource.setPassword(password);
                return dataSource.getConnection();
            }
            return dataSource.getConnection();
    }
    public static void close(Connection connection, PreparedStatement state, ResultSet set) throws SQLException {
        if(set!=null){
           set.close();
        }
        if(state!=null){
            state.close();
        }
        if(connection!=null){
            connection.close();
        }
    }
}
