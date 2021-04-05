package services;

import dao.WorkDatabase;
import models.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        int suss=0;
        String msg="";
        if(username!=null&&password!=null){
            WorkDatabase work=new WorkDatabase();
            try {
                UserInfo userInfo=work.select(username,password);
                if(userInfo.getId()>0){
                    msg="用户名已存在!";
                }else{
                    suss=work.add(username,password);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else{
            msg="操作失败!用户名或密码不合法!";
        }
        PrintWriter print=response.getWriter();
        //{"suss":%d,"msg":"%s"}
        print.println(String.format("{\"suss\":%d,\"msg\":\"%s\"}",suss,msg));
    }
}
