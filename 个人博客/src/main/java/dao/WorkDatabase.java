package dao;

import models.MyArtical;
import models.UserInfo;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkDatabase {
    public int add(String username,String password) throws SQLException {
        Connection connection= JDBC.dataSourse();
        String sql="insert into userinfo(username,password) values(?,?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        int count=statement.executeUpdate();
        JDBC.close(connection,statement,null);
        return count;
    }
    public UserInfo select(String username, String password) throws SQLException {
      Connection connection=JDBC.dataSourse();
      String sql="select * from userinfo where username=? and password=?";
      PreparedStatement statement=connection.prepareStatement(sql);
      statement.setString(1,username);
      statement.setString(2,password);
        ResultSet resultSet=statement.executeQuery();
        UserInfo userInfo=new UserInfo();
       if(resultSet.next()){
            userInfo.setId(resultSet.getInt("id"));
            userInfo.setUsername(resultSet.getString("username"));
            userInfo.setPassword(resultSet.getString("password"));
        }
        JDBC.close(connection,statement,resultSet);
        return userInfo;
    }
    public List<MyArtical> select(int uid) throws SQLException {
        Connection connection=JDBC.dataSourse();
        String sql="select * from  articleinfo where uid=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,uid);
        ResultSet resultSet=statement.executeQuery();
        List<MyArtical>list=new ArrayList<>();
        while(resultSet.next()){
            MyArtical articleInfo = new MyArtical();
            articleInfo.setId(resultSet.getInt("id"));
            articleInfo.setRcount(resultSet.getInt("rcount"));
            articleInfo.setTitle(resultSet.getString("title"));
            articleInfo.setContent(resultSet.getString("content"));
            articleInfo.setCreatetime(resultSet.getDate("createtime"));
            list.add(articleInfo);
        }
        JDBC.close(connection,statement,resultSet);
        return list;
    }
    public int delete(int id) throws SQLException {
        Connection connection=JDBC.dataSourse();
        String sql="delete from articleinfo where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int result=preparedStatement.executeUpdate();
        JDBC.close(connection,preparedStatement,null);
        return result;
    }
    public MyArtical search(int id) throws SQLException {
        Connection connection=JDBC.dataSourse();
        String sql="select * from articleinfo where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        MyArtical myArtical=new MyArtical();
        if(resultSet.next()){
            myArtical.setTitle(resultSet.getString("title"));
            myArtical.setContent(resultSet.getString("content"));
        }
        JDBC.close(connection,preparedStatement,resultSet);
        return myArtical;
    }
    public int updateArt(int id,String title,String content) throws SQLException {
        Connection connection=JDBC.dataSourse();
        String sql="update articleinfo set title=?,content=? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,title);
        preparedStatement.setString(2,content);
        preparedStatement.setInt(3,id);
        int result=preparedStatement.executeUpdate();
        JDBC.close(connection,preparedStatement,null);
        return result;
    }
    public int addArt(int uid,String title,String content) throws SQLException {
        Connection connection=JDBC.dataSourse();
        String sql="insert into articleinfo (title,content,uid) values (?,?,?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,title);
        statement.setString(2,content);
        statement.setInt(3,uid);
        int result=statement.executeUpdate();
        JDBC.close(connection,statement,null);
        return result;
    }
}
