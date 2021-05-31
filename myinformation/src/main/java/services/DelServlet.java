package services;

import dao.WorkDatabase;
import utils.GetUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/mydel")
public class DelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      int succ=-1;
      String msg="";
      int id=Integer.parseInt(req.getParameter("id"));
      if(id>0){
          WorkDatabase work=new WorkDatabase();
          try {
              succ=work.delete(id);
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }
      }else{
          msg="操作不合法!没有你要删除的文章!";
      }
        HashMap<String,Object>map=new HashMap<>();
      map.put("succ",succ);
      map.put("masg",msg);
        GetUser getUser=new GetUser();
        getUser.getUser(resp,map);
    }
}
