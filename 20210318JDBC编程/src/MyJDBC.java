import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class MyJDBC {
    public static void main1(String[] args) throws SQLException {
        try {
            /*
            加载驱动程序
        */
            Class.forName("com.mysql.jdbc.Driver");//加载驱动程序
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
        * 建立连接
        * */
        String url="jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false";//定位数据库所在的客户端
        String name="root";//用户名
        String password="123456";//密码
        Connection connection=DriverManager.getConnection(url,name,password);//获取连
       /*
       * 执行sql语句
       * */
        String sql="select * from user";
        Statement statement=connection.createStatement();
        ResultSet resultset=statement.executeQuery(sql);
        while(resultset.next()){
            System.out.print("id="+resultset.getInt(1)+" ");
            System.out.print("acount="+resultset.getString(2)+" ");
            System.out.println("amount="+resultset.getInt(3));
        }
    }
/***********************字符串拼接变量时，容易出现sql注入*************************/
    public static void main2(String[] args) throws SQLException {
        try {
            /*
            加载驱动程序
        */
            Class.forName("com.mysql.jdbc.Driver");//加载驱动程序
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
         * 建立连接
         * */
        String url="jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false";//定位数据库所在的客户端
        String name="root";//用户名
        String password="123456";//密码
        Connection connection=DriverManager.getConnection(url,name,password);//获取连
        /*
         * 执行sql语句
         * */
        int id=1;
        String sql="select * from user where id='"+id+"'";
        Statement statement=connection.createStatement();
        ResultSet resultset=statement.executeQuery(sql);
        while(resultset.next()){
            System.out.print("id="+resultset.getInt(1)+" ");
            System.out.print("acount="+resultset.getString(2)+" ");
            System.out.println("amount="+resultset.getInt(3));
        }
    }
/********************改进*********************/
    public static void main(String[] args) throws SQLException {
        try {
            /*
            加载驱动程序
        */
            Class.forName("com.mysql.jdbc.Driver");//加载驱动程序
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
         * 建立连接
         * */
        String url="jdbc:mysql://127.0.0.1:3306/mydatabase?useSSL=false";//定位数据库所在的客户端
        String name="root";//用户名
        String password="123456";//密码
        DataSource dataSource=new MysqlDataSource();//获取连接
        /*数据源*/
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(name);
        ((MysqlDataSource)dataSource).setPassword(password);
        
        Connection connection=dataSource.getConnection();
        /*
         * 执行sql语句
         * */
        String sql="select * from user where id=? or id=?";//进一步解决sql注入
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,1);
        statement.setInt(2,250);
        ResultSet resultset=statement.executeQuery();//对sql语句进行优化，减少sql注入的可能
        while(resultset.next()){
            System.out.print("id="+resultset.getInt(1)+" ");
            System.out.print("acount="+resultset.getString(2)+" ");
            System.out.println("amount="+resultset.getInt(3));
        }
        resultset.close();
        statement.close();
        connection.close();
    }
}
