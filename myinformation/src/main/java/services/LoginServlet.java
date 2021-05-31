package services;

import dao.WorkDatabase;
import models.UserInfo;
import utils.GetUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
@WebServlet("/logininfor")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetUser user=new GetUser();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        int succ=-1;
        String msg="";
        HashMap<String,Object> map=new HashMap<>();
        WorkDatabase work=new WorkDatabase();
        HttpSession session = request.getSession();
        try {
            UserInfo userInfo=work.select(username,password);
                session.setAttribute("userinfo",userInfo);
                succ=1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(succ<0){
            msg="用户不存在!";
        }
        map.put("succ",succ);
        map.put("msg",msg);
        user.getUser(response,map);
    }
}
