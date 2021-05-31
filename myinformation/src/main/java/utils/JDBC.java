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
                String url="jdbc:mysql://127.0.0.1:3306/javainfor";
                String user="root";
                String password="12345678";
                dataSource.setCharacterEncoding("utf-8");
                dataSource.setUrl(url);
                dataSource.setUser(user);
                dataSource.setPassword(password);
                dataSource.setUseSSL(false);
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
